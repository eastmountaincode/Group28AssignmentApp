package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;


public class DatabaseReceivedListFragment extends Fragment {

    public DatabaseReceivedListFragment() {
        // Required empty public constructor
    }

    public static DatabaseReceivedListFragment newInstance(String param1, String param2) {
        DatabaseReceivedListFragment fragment = new DatabaseReceivedListFragment();

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
        return inflater.inflate(R.layout.fragment_database_received_list, container, false);
    }
}