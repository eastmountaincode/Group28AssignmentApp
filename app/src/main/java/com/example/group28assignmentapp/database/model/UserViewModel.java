package com.example.group28assignmentapp.database.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.group28assignmentapp.database.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<List<String>> _listOfUsernames = new MutableLiveData<>();
    public final LiveData<List<String>> listOfUsernames = _listOfUsernames;  // observable

    private final MutableLiveData<User> _user = new MutableLiveData<>();  // Mutable. Change this.
    public final LiveData<User> user = _user;  // Observable. Not Mutable.

    // References to the Realtime DB:
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private final String TAG = "REALTIME-DATABASE";

    public void mListenToDatabase() {

    }

    public void attemptToLoginUsername(String username) {
        // Ensure that database connection is setup
        // Check if a user with username exists
        // Set the logged in user to the User with the username username
    }



}
