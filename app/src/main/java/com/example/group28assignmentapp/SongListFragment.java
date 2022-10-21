package com.example.group28assignmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.FragmentSongListBinding;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SongListFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentSongListBinding binding;
    private TextView dummyText;
    private Handler handler;
    private URL url;
    String result = "";


    public SongListFragment() {
        // Required empty public constructor
    }

    public static SongListFragment newInstance() {
        return new SongListFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSongListBinding.inflate(inflater, container, false);
        dummyText = binding.dummyText;
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(MainViewModel.class);

        return binding.getRoot();
    }

    public void updateSongList(String genre) {
        dummyText.setText(genre);
        handler = new Handler();
        MyThread thread = new MyThread();
        thread.start();

    }

        public static String convertStreamToString(InputStream inputStream){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String len;
            while((len=bufferedReader.readLine())!=null){
                stringBuilder.append(len);
            }
            bufferedReader.close();
            return stringBuilder.toString().replace(",", ",\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

        private class MyThread extends Thread {
        @Override
        public void run() {

            try {
                url = new URL("https://google.com");
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                try {
                    urlc.setRequestProperty("Connection", "close");
                    urlc.setConnectTimeout(1000 * 30); // Timeout is in seconds

                    InputStream inputStream = new BufferedInputStream(urlc.getInputStream());
                    result = SongListFragment.convertStreamToString(inputStream);
                }
                finally {
                    urlc.disconnect();
                }


            }
            catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    dummyText.setText(result);
                }
            });

        }
    }
}