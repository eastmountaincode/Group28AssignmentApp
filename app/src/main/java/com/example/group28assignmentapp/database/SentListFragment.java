package com.example.group28assignmentapp.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.group28assignmentapp.databinding.FragmentSentListBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SentListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SentListFragment extends Fragment {

    private FragmentSentListBinding binding;


    public SentListFragment() {
        // Required empty public constructor
    }

    public static SentListFragment newInstance(String param1, String param2) {
        SentListFragment fragment = new SentListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}