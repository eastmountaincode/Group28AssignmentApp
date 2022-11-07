package com.example.group28assignmentapp.database;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.customrecycler.DatabaseRecyclerAdapter;
import com.example.group28assignmentapp.database.model.MessageViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ReceivedListFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private final String TAG = "REALTIME-DATABASE-STICKER";
    private MessageViewModel sharedViewModel;
    private String username;
    private ArrayList<Sticker> stickerList;

    // Store the last stickers seen so we can identify which sticker is new when a new
    // sticker is received:
    private ArrayList<Sticker> lastStickerList;
    boolean initialLoad = true;


    public ReceivedListFragment() {
        // Required empty public constructor
    }

    public static ReceivedListFragment newInstance(String param1, String param2) {
        ReceivedListFragment fragment = new ReceivedListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(MessageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_received_list, container, false);
        stickerList = new ArrayList<>();
        lastStickerList = new ArrayList<>();

        // Setup the recycler view
        recyclerView = view.findViewById(R.id.received_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseRecyclerAdapter adapter = new DatabaseRecyclerAdapter(getContext(), (ArrayList<Sticker>) stickerList);
        recyclerView.setAdapter(adapter);

        // Get username from the viewmodel and ask for pertinent user info rom the database:
        username = sharedViewModel.getUsername();
        mDatabase = FirebaseDatabase.getInstance().getReference("users3/" + username + "/received");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // We will be updating the UI to reflect the contents of stickerList, so need to
                // clear old entries if there are any:
                lastStickerList = (ArrayList<Sticker>) stickerList.clone();
                stickerList.clear();

                // If no stickers have been received, the snapshot value will be null
                if ((snapshot.getValue() == null)) {
                    return;
                }

                Sticker newSticker = new Sticker();
                // Every child of the snapshot is a Sticker. We want to add all these stickers to
                // our list of stickers
                for (DataSnapshot shot : snapshot.getChildren()) {
                    Sticker sticker = shot.getValue(Sticker.class);
                    if (!initialLoad && !lastStickerList.contains(sticker)) {
                        newSticker = sticker;
                    }
                    stickerList.add(sticker);
                }

                // Update the recyclerview in the UI:
                adapter.notifyDataSetChanged();

                if (!initialLoad) {
                    // Don't send notifications on first read of database
                    notifyNewMessageReceived(newSticker);
                }

                if (initialLoad) {
                    initialLoad = false;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

    // Method adapted from example code provided in class:
    public void notifyNewMessageReceived(Sticker sticker) {

        // Get Bitmap of sticker received so that we can display it in the notif:
        int id = getContext().getResources().getIdentifier(sticker.getSticker_number(),
                "drawable",
                getContext().getPackageName());
        Bitmap icon = BitmapFactory.decodeResource(getContext().getResources(),
                id);

        // Build notification:
        String channelID = getString(R.string.channel_id);
        Notification notif = new NotificationCompat.Builder(this.getContext(), channelID)
                .setContentTitle("New Sticker!")
                .setContentText("Someone sent you a sticker - find out who!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(icon)
                .build();

        // Get the notification service from the system:
        NotificationManager notifManager = (NotificationManager) this.getContext()
                .getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        notif.flags |= Notification.FLAG_AUTO_CANCEL;

        notifManager.notify(0, notif);
    }

}