package com.example.group28assignmentapp.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.model.MessageViewModel;


public class ReceivedListFragment extends Fragment {

    private MessageViewModel sharedViewModel;

    public ReceivedListFragment() {
        // Required empty public constructor
    }

    public static ReceivedListFragment newInstance(String param1, String param2) {
        ReceivedListFragment fragment = new ReceivedListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(MessageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_received_list, container, false);
    }
}