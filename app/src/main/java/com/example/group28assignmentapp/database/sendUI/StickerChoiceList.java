package com.example.group28assignmentapp.database.sendUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.group28assignmentapp.R;

public class StickerChoiceList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String currentUser;
    private StickerRecyclerAdapter.RecyclerViewClickListener listener;
    private final static String TAG = "REALTIME-DATABASE-STICKERCHOICE";
    private String chosenUser;

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
                // add a new sticker to the database based
                // on who sent it, who is getting it, and which
                // sticker it was
            }
        };



    }
}