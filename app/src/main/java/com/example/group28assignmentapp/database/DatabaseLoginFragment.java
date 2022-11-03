package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.FragmentDatabaseLoginBinding;


public class DatabaseLoginFragment extends Fragment {

    private DatabaseViewModel databaseViewModel;
    private FragmentDatabaseLoginBinding binding;



    public DatabaseLoginFragment() {
        // Required empty public constructor
    }

    public static DatabaseLoginFragment newInstance() {
        DatabaseLoginFragment fragment = new DatabaseLoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);
        databaseViewModel.loadUsernames();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDatabaseLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}