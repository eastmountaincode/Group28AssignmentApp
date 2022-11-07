package com.example.group28assignmentapp.database;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SentListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SentListFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private final String TAG = "REALTIME-DATABASE-STICKER";
    private MessageViewModel sharedViewModel;
    private String username;
    private ArrayList<Sticker> stickerList;

    public SentListFragment() {
        // Required empty public constructor
    }

    public static SentListFragment newInstance() {
        SentListFragment fragment = new SentListFragment();
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
        View view = inflater.inflate(R.layout.fragment_sent_list, container, false);
        stickerList = new ArrayList<>();

        // Setup recycler view
        recyclerView = view.findViewById(R.id.sent_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseRecyclerAdapter adapter = new DatabaseRecyclerAdapter(getContext(), stickerList);
        recyclerView.setAdapter(adapter);

        // TODO: Get list of sent stickers from the database for a particular user DONE!!!
        username = sharedViewModel.getUsername();
        mDatabase = FirebaseDatabase.getInstance().getReference("users3/" + username + "/sent");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "Attempting data change");

                stickerList.clear();  // Data Changed. Need to refresh list of stickers

                if ((dataSnapshot.getValue() == null)) {
                    Log.d(TAG, "data snapshot is null");
                    return;
                }
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Sticker sticker = snapshot.getValue(Sticker.class);
                    stickerList.add(sticker);
                }
                Log.d(TAG, "Data changed to " + stickerList.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return view;
    }

}