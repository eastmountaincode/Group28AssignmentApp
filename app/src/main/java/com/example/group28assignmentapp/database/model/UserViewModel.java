package com.example.group28assignmentapp.database.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.group28assignmentapp.database.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Objects;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<List<String>> _listOfUsernames = new MutableLiveData<>();
    public final LiveData<List<String>> listOfUsernames = _listOfUsernames;  // observable

    private final MutableLiveData<User> _user = new MutableLiveData<>();  // Mutable. Change this.
    public final LiveData<User> user = _user;  // Observable. Not Mutable.

    // References to the Realtime DB:
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private final String TAG = "REALTIME-DATABASE";

    // TODO: Do we even need this method? Can we just have this in the class scope?
    public void mListenToDatabase() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // loop all the data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    _listOfUsernames.getValue().add(user.getUsername());
                    Log.d(TAG, user.getUsername());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void attemptToLoginUsername(String username) {
        // Ensure that database connection is setup
        // Check if a user with username exists
        // Set the logged in user to the User with the username username
    }



}
