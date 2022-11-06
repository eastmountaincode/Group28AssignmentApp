package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.databinding.FragmentSimpleBottomNavBinding;


public class SimpleBottomNav extends Fragment {

    private FragmentSimpleBottomNavBinding binding;

    public SimpleBottomNav() {
        // Required empty public constructor
    }

    public static SimpleBottomNav newInstance() {
        SimpleBottomNav fragment = new SimpleBottomNav();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSimpleBottomNavBinding.inflate(inflater, container, false);

        binding.sentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SentListFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.messageContainer, fragment);
                fragmentTransaction.commit();
            }
        });

        binding.receivedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ReceivedListFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.messageContainer, fragment);
                fragmentTransaction.commit();
            }
        });


        return binding.getRoot();
    }
}