package com.example.group28assignmentapp.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group28assignmentapp.R;
import com.example.group28assignmentapp.database.customrecycler.DatabaseRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SentListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SentListFragment extends Fragment {
    private RecyclerView recyclerView;

    public SentListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SentListFragment.
     */
    public static SentListFragment newInstance() {
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sent_list, container, false);

        // TODO: Get list of sent stickers from the database for a particular user

        // Setup recycler view
        recyclerView = view.findViewById(R.id.sent_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // TODO: add adapter with that list of sent stickers:
//        recyclerView.setAdapter(new DatabaseRecyclerAdapter(sentStickers));

        return view;
    }
}