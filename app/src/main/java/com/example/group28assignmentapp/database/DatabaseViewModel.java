package com.example.group28assignmentapp.database;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DatabaseViewModel extends ViewModel {
    private ArrayList<String> listOfUsernames;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    private final String TAG = "REALTIME-DATABASE";
    List<String> usernames;
    private String currentUser;

    public void loadUsernames() {
        // TODO: load the usernames from the database into listOfUsernames so we can
        // check if the one the user enters exists, or if the user wants to create a NEW user,
        // we must check that that username doesn't already exist

        // Want app data to update in real time when the database updates.
        // To do this, we add an event listener the the mUsers reference above:
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Log.d(TAG, "UserMap value is: " + map);
                usernames = new ArrayList<>(Objects.requireNonNull(map).keySet());
                Log.d(TAG, "Usernames are: " + usernames);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

   public String getCurrentUser() {
        return this.currentUser;
   }

   public void setCurrentUser(String currentUser1) {
        this.currentUser = currentUser1;
   }


}
