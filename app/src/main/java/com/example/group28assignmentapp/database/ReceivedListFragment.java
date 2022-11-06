package com.example.group28assignmentapp.database;

import android.os.Bundle;
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
import java.util.List;


public class ReceivedListFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private String username;
    private ArrayList<Sticker> stickerList;
    private MessageViewModel sharedViewModel;

    public ReceivedListFragment() {
        // Required empty public constructor
    }

    public static ReceivedListFragment newInstance() {
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
        recyclerView = view.findViewById(R.id.received_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseRecyclerAdapter adapter = new DatabaseRecyclerAdapter(getContext(), stickerList);
        recyclerView.setAdapter(adapter);

        username = sharedViewModel.getUsername();
        mDatabase = FirebaseDatabase.getInstance().getReference("users3/" + username + "/received");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stickerList.clear();

                if ((dataSnapshot.getValue() == null)){
                    return;
                }
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Sticker sticker = snapshot.getValue(Sticker.class);
                    stickerList.add(sticker);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });

        return view;
    }
}