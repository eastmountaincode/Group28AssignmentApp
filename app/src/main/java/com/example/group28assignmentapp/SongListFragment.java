package com.example.group28assignmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.FragmentSongListBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class SongListFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentSongListBinding binding;
    private TextView dummyText;
    private Handler handler;
    private URL url;
    String result = "";
    private String lastFMAPIKey = "c0355388e06690d06f415808862dc1fe";
    private JsonObject root;
    private String category;


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

        // Get accessor for ViewModel
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(MainViewModel.class);  // Get accessor to viewModel

        return binding.getRoot();
    }

    public void getNewChart(String category) {
        this.category = category;
        handler = new Handler();
        MyThread thread = new MyThread();
        thread.start();
    }

    public static String convertStreamToString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String len;
            while ((len = bufferedReader.readLine()) != null) {
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
                if (category.equals("Top Tracks")) {
                    url = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=c0355388e06690d06f415808862dc1fe&format=json");
                }
                if (category.equals("Top Artists")) {
                    url = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=c0355388e06690d06f415808862dc1fe&format=json");
                }
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();

                result = convertStreamToString(inputStream);
                JsonElement jsonElement = JsonParser.parseString(result);
                root = jsonElement.getAsJsonObject();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            handler.post(new Runnable() {
                @Override
                public void run() {
                    JsonArray topSongs = root.get("tracks")
                            .getAsJsonObject()
                            .get("track")
                            .getAsJsonArray();
                    JsonObject topSong = topSongs.get(0).getAsJsonObject();  // Get #1 track
                    String topSongName = topSong.get("name").getAsString();  // Get name of #1
                    ArrayList<Entry> listOfTopSongs = new ArrayList<>();
                    int count = 0;
                    for (JsonElement elem : topSongs) {
                        count++;
                        String songName = elem.getAsJsonObject().get("name").getAsString();
                        String artistName = elem.getAsJsonObject()
                                .get("artist").getAsJsonObject()
                                .get("name").getAsString();
                        String rank = String.valueOf(count);
                        Entry e = new Entry(songName, artistName, rank);
                        listOfTopSongs.add(e);
                    }
                    viewModel.setEntryList(listOfTopSongs);
                    dummyText.setText(viewModel.getEntryList().get(0).toString());
                }
            });

        }
    }
}