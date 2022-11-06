package com.example.group28assignmentapp.database.sendUI;

import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.group28assignmentapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecipientChoiceList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String currentUser;
    private DatabaseReference mDatabase;
    private UserRecyclerAdapter.RecyclerViewClickListener listener;
    private ArrayList<String> usernameList;
    private final static String TAG = "REALTIME-DATABASE-RECIPIENTCHOICE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_choice_list);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.currentUser = extras.getString("USERNAME");
        }

        usernameList = new ArrayList<>();

        recyclerView = findViewById(R.id.stickerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listener = new UserRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), StickerChoiceList.class);
                intent.putExtra("USERNAME", currentUser);
                intent.putExtra("CHOSENUSER",usernameList.get(position));
                startActivity(intent);
                finish();
            }
        };
        UserRecyclerAdapter adapter = new UserRecyclerAdapter(usernameList, currentUser,listener);
        recyclerView.setAdapter(adapter);

        mDatabase = FirebaseDatabase.getInstance().getReference("users3");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(TAG, snapshot.toString());
                usernameList.clear();

                if ((snapshot.getValue() == null)){
                    return;
                }
                for (DataSnapshot shot : snapshot.getChildren()){
                    usernameList.add(shot.getKey().toString());
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



}