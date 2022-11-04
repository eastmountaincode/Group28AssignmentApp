package com.example.group28assignmentapp.database;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DatabaseViewModel extends ViewModel {
    private final Set<String> listOfUsernames = new HashSet<>();
    private final Map<String, User> users = new HashMap<>();
    private User currentUser;

    // TODO: Abstract the Path outta this to some config file or enum or something
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private final String TAG = "REALTIME-DATABASE";



    public void listenToDatabase() {
        // TODO: load the usernames from the database into listOfUsernames so we can
        // check if the one the user enters exists, or if the user wants to create a NEW user,
        // we must check that that username doesn't already exist

        // Want app data to update in real time when the database updates.
        // To do this, we add an event listener the the mUsers reference above:
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // loop all the data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    users.put(Objects.requireNonNull(user).getUsername(), user);  //
                    listOfUsernames.add(user.getUsername());  // For speedy lookup
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public boolean userExists(String username) {
        return listOfUsernames.contains(username);
    }

    public void createUser(String username) {
        // TODO: Implement this method!
        User newUser = new User(username);
        mDatabase.child(username).setValue(newUser);
    }

//   public String getCurrentUser() {
//        return this.currentUser;
//   }
//
//   public void setCurrentUser(String currentUser1) {
//        this.currentUser = currentUser1;
//   }


}
