package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.database.model.UserViewModel;
import com.example.group28assignmentapp.databinding.FragmentReceivedBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link receivedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class receivedFragment extends Fragment {

    private FragmentReceivedBinding binding;
    private UserViewModel sharedViewModel;

    public receivedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment receivedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static receivedFragment newInstance() {
        receivedFragment fragment = new receivedFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the viewModel hosted by the _activity_
        sharedViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        // TODO: is sharedViewModel already listening to db at this point?
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentReceivedBinding bind = FragmentReceivedBinding.inflate(inflater, container,
                false);
        binding = bind;
        return binding.getRoot();
    }
}