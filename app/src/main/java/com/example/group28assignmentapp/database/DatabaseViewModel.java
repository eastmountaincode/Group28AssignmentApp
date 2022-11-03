package com.example.group28assignmentapp.database;

import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DatabaseViewModel extends ViewModel {
    private ArrayList<String> listOfUsernames;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public void loadUsernames() {
        //TODO: load the usernames from the database into listOfUsernames so we can
        // check if the one the user enters exists, or if the user wants to create a NEW user,
        // we must check that that username doesn't already exist
    }


}
