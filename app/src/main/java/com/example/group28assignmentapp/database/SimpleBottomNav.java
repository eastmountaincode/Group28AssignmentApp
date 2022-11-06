package com.example.group28assignmentapp.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.model.MessageViewModel;
import com.example.group28assignmentapp.database.sendUI.RecipientChoiceList;
import com.example.group28assignmentapp.databinding.FragmentSimpleBottomNavBinding;


public class SimpleBottomNav extends Fragment {

    private FragmentSimpleBottomNavBinding binding;
    private MessageViewModel sharedViewModel;

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
        sharedViewModel = new ViewModelProvider(requireActivity()).get(MessageViewModel.class);
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

        binding.sendStickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), RecipientChoiceList.class);
                myIntent.putExtra("USERNAME", sharedViewModel.getUsername());
                startActivity(myIntent);
            }
        });


        return binding.getRoot();
    }
}