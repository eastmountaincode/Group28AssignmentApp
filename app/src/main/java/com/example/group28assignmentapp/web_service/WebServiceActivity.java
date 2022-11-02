package com.example.group28assignmentapp.web_service;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.ActivityWebServiceBinding;
import com.example.group28assignmentapp.web_service.GenreGetFragment;
import com.example.group28assignmentapp.web_service.SongListFragment;

import java.net.URL;

public class WebServiceActivity extends AppCompatActivity {
    private ActivityWebServiceBinding binding;
    private TextView dummyText;
    private URL url;
    private Handler handler;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebServiceBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.bottomPart, GenreGetFragment.newInstance())
                    .commitNow();
        }
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.topPart, SongListFragment.newInstance(), "SongList")
                    .commitNow();
        }


    }

}