package com.example.group28assignmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.group28assignmentapp.databinding.FragmentSongListBinding;

public class SongListFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentSongListBinding binding;
    private TextView dummyText;


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

    public void updateSongList() {
        dummyText.setText(viewModel.getCurrentGenre());
        Log.d("asd", "genre is " + viewModel.getCurrentGenre());
        Log.d("asd", "genre is " + viewModel.getCurrentGenre());
        Log.d("asd", "genre is " + viewModel.getCurrentGenre());
        Log.d("asd", "genre is " + viewModel.getCurrentGenre());
        Log.d("asd", "genre is " + viewModel.getCurrentGenre());
    }
}