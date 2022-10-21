package com.example.group28assignmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.group28assignmentapp.databinding.FragmentGenreGetBinding;

public class GenreGetFragment extends Fragment {
    private Spinner spinner;
    private FragmentGenreGetBinding binding;
    private Button getButton;
    private String genreToGet;
    private MainViewModel viewModel;



    public GenreGetFragment() {
        // Required empty public constructor
    }

    public static GenreGetFragment newInstance() {return new GenreGetFragment();}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGenreGetBinding.inflate(inflater, container, false);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(MainViewModel.class);

        spinner = binding.genreSpinner;
        getButton = binding.getButton;
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genreToGet = spinner.getSelectedItem().toString();
                viewModel.setCurrentGenre(genreToGet);
                Log.d("asd", "genre is " + genreToGet);
                Log.d("asd", "genre is " + genreToGet);
                Log.d("asd", "genre is " + genreToGet);
                Log.d("asd", "genre is " + genreToGet);
                Log.d("asd", "genre is " + genreToGet);

                Log.d("asd", "genre is " + viewModel.getCurrentGenre());
                Log.d("asd", "genre is " + viewModel.getCurrentGenre());
                Log.d("asd", "genre is " + viewModel.getCurrentGenre());
                Log.d("asd", "genre is " + viewModel.getCurrentGenre());
                Log.d("asd", "genre is " + viewModel.getCurrentGenre());
                SongListFragment songListFragment = (SongListFragment) getParentFragmentManager().findFragmentByTag("SongList");
                songListFragment.updateSongList();

            }
        });

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(), R.array.genres, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        return binding.getRoot();
    }
}