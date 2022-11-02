package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;


public class DatabaseLoginFragment extends Fragment {



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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_database_login, container, false);
    }
}