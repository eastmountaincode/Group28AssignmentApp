package com.example.group28assignmentapp.database.main_message_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;

public class DatabaseBottomNavFragment extends Fragment {


    public DatabaseBottomNavFragment() {
        // Required empty public constructor
    }

    public static DatabaseBottomNavFragment newInstance() {
        DatabaseBottomNavFragment fragment = new DatabaseBottomNavFragment();
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
        return inflater.inflate(R.layout.fragment_database_bottom_nav, container, false);
    }
}