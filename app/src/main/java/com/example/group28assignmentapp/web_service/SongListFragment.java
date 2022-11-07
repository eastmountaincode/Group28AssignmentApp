package com.example.group28assignmentapp.web_service;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group28assignmentapp.databinding.FragmentSongListBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class SongListFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentSongListBinding binding;
    private Handler handler;
    private URL url;
    String result = "";
    private final String lastFMAPIKey = "c0355388e06690d06f415808862dc1fe";
    private JsonObject root;
    private Category category;
    ArrayList<Entry> listOfTopSongs = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private LoadingDialog loadingDialog;


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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSongListBinding.inflate(inflater, container, false);
        recyclerView = binding.songListView;


        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));


        // Get accessor for ViewModel
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(MainViewModel.class);  // Get accessor to viewModel
        adapter = new RecyclerAdapter(this.getContext(), viewModel.getEntryList());
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    public void getNewChart(Category category) {

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
            // This is where the progress dialog should start

            try {
                if (category.equals(Category.TOP_SONGS)) {
                    url = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=c0355388e06690d06f415808862dc1fe&format=json&limit=5");
                }
                if (category.equals(Category.TOP_ARTISTS)) {
                    url = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=c0355388e06690d06f415808862dc1fe&format=json&limit=5");
                }
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();

                result = convertStreamToString(inputStream);
                JsonElement jsonElement = JsonParser.parseString(result);
                root = jsonElement.getAsJsonObject();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (category.equals(Category.TOP_SONGS)) {
                handleTopTracks(root);
            } else {
                handleTopArtists(root);
            }
        }

        private void handleTopArtists(JsonObject root) {
            handler.post(() -> {
                loadingDialog = new LoadingDialog(getActivity());
                loadingDialog.startLoadingDialog();

                JsonArray topArtists = root.get("artists")
                        .getAsJsonObject()
                        .get("artist")
                        .getAsJsonArray();

                int count = 0;
                listOfTopSongs.clear();
                for (JsonElement elem : topArtists) {
                    count++;
                    String artistName = elem.getAsJsonObject().get("name").getAsString();

                    String rank = String.valueOf(count);
                    Entry e = new Entry("", artistName, rank);
                    e.setSubtitle("");
                    e.setTitle(artistName);
                    e.setRank(rank);
                    listOfTopSongs.add(e);
                }
                viewModel.setEntryList(listOfTopSongs);
                recyclerView.setAdapter(new RecyclerAdapter(binding.getRoot().getContext(),
                        viewModel.getEntryList()));

                loadingDialog.dismissDialog();
            });
        }


        private void handleTopTracks(JsonObject root) {
            handler.post(() -> {
                loadingDialog = new LoadingDialog(getActivity());
                loadingDialog.startLoadingDialog();

                JsonArray topSongs = root.get("tracks")
                        .getAsJsonObject()
                        .get("track")
                        .getAsJsonArray();

                int count = 0;
                listOfTopSongs.clear();
                for (JsonElement elem : topSongs) {
                    count++;
                    String songName = elem.getAsJsonObject().get("name").getAsString();

                    String artistName = elem.getAsJsonObject()
                            .get("artist").getAsJsonObject()
                            .get("name").getAsString();
                    String rank = String.valueOf(count);
                    Entry e = new Entry(songName, artistName, rank);
                    e.setSubtitle(artistName);
                    e.setTitle(songName);
                    e.setRank(rank);
                    listOfTopSongs.add(e);
                }

                viewModel.setEntryList(listOfTopSongs);
                recyclerView.setAdapter(new RecyclerAdapter(binding.getRoot().getContext(),
                        viewModel.getEntryList()));


                loadingDialog.dismissDialog();

            });

        }
    }
}