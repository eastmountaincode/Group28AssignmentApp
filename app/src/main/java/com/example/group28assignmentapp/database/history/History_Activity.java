package com.example.group28assignmentapp.database.history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.group28assignmentapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class History_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String currentUser;
    private final static String TAG = "REALTIME-DATABASE-HISTORY";
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private final ArrayList<String> stickerStringList = new ArrayList<>(Arrays.asList("pavlu", "clark", "feinberg", "park"));
    private ArrayList<Integer> countList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        countList = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.currentUser = extras.getString("USERNAME");
        }
        this.mDatabase = mDatabase.child(this.currentUser).child("sent");
        this.mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // loop all the data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Populate the count list
                    String stickerName = snapshot.child("sticker_number").getValue().toString();
                    Integer index = stickerStringList.indexOf(stickerName);
                    countList.set(index, countList.get(index) + 1);

                }
                Log.d(TAG, countList.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        recyclerView = findViewById(R.id.history_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HistoryRecyclerAdapter adapter = new HistoryRecyclerAdapter(this.currentUser, countList);
        recyclerView.setAdapter(adapter);
    }

}