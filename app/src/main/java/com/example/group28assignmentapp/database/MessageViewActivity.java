package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group28assignmentapp.R;

public class MessageViewActivity extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getIntent().getStringExtra("USERNAME");

        setContentView(R.layout.activity_message_view);
    }
}