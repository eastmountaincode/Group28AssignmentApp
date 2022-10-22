package com.example.group28assignmentapp;

import static android.view.View.Z;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.ActivityMainBinding;
import com.example.group28assignmentapp.databinding.ActivityWebServiceBinding;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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