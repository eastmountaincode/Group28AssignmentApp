package com.example.group28assignmentapp.database;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group28assignmentapp.R;

public class DatabaseMainActivity extends AppCompatActivity implements MessageViewActivity.OnFragmentInteractionListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri url) {

    }
}
