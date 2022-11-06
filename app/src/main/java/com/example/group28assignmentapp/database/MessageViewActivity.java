package com.example.group28assignmentapp.database;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.model.MessageViewModel;

public class MessageViewActivity extends AppCompatActivity {
    private String username;
    private MessageViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getIntent().getStringExtra("USERNAME");
        sharedViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        sharedViewModel.setUsername(username);
        setContentView(R.layout.activity_message_view);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to log out?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                        .setNegativeButton("No",null)
                                .show();

    }
}