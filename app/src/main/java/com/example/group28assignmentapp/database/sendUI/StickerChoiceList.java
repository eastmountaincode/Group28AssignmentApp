package com.example.group28assignmentapp.database.sendUI;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.Sticker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class StickerChoiceList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String currentUser;
    private StickerRecyclerAdapter.RecyclerViewClickListener listener;
    private final static String TAG = "REALTIME-DATABASE-STICKERCHOICE";
    private String chosenUser;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private ArrayList<String> stickerStringList = new ArrayList<>(Arrays.asList("pavlu", "clark", "feinberg", "park"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticker_choice_list);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.currentUser = extras.getString("USERNAME");
            this.chosenUser = extras.getString("CHOSENUSER");
        }

        recyclerView = findViewById(R.id.stickerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listener = new StickerRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                // add a new message event to the database based
                // on who sent it, who is getting it, and which
                // sticker it was

                // add sticker to sender's profile
                DatabaseReference ref = mDatabase.child(currentUser).child("sent");
                ref.push().setValue(new Sticker(chosenUser, stickerStringList.get(position)));

                // add sticker to recipient's profile
                ref = mDatabase.child(chosenUser).child("received");
                ref.push().setValue(new Sticker(currentUser, stickerStringList.get(position)));

                finish();

            }
        };
        StickerRecyclerAdapter adapter = new StickerRecyclerAdapter(this.currentUser, listener);
        recyclerView.setAdapter(adapter);


    }
}