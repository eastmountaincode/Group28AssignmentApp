package com.example.group28assignmentapp.database.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.group28assignmentapp.database.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<List<String>> _listOfUsernames = new MutableLiveData<>(new ArrayList<String>());
    public final LiveData<List<String>> listOfUsernames = _listOfUsernames;  // observable

    private final MutableLiveData<User> _user = new MutableLiveData<>();  // Mutable. Change this.
    public final LiveData<User> user = _user;  // Observable. Not Mutable.

    // References to the Realtime DB:
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users3");
    private DatabaseReference mUser = null;
    private final String TAG = "REALTIME-DATABASE";

    private boolean listenerSet = false;    // flag indicating if DB listner has been setup

    // TODO: Do we even need this method? Can we just have this in the class scope?
    public void mListenToDatabase() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // loop all the data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    // Get the users as user objects and then append their usernames to the private
                    // MutableLiveData of usernames:
                    User user = snapshot.getValue(User.class);
                    _listOfUsernames.getValue().add(user.getUsername());
                    Log.d(TAG, user.getUsername());
                    Log.d(TAG, _listOfUsernames.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        listenerSet = true;
    }

    public boolean attemptToLoginUsername(String username) {
        // Ensure that database connection is setup
        if (!listenerSet) {
            this.mListenToDatabase();
        }

        // Check if a user with username exists
        if (_listOfUsernames.getValue().contains(username)) {
            // Set the logged in user to the User with the username username
            mUser = mDatabase.child(username);
            mUser.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                // We only need to get the data _once_ so we use an OnCompleteListener instead of
                // a ValueEventListener
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                        User loggedInUser = task.getResult().getValue(User.class);
                        _user.setValue(loggedInUser);
                    }
                }
            });
            return true;  // We found the user
        }
        return false;  // We did not find the user
    }

    public boolean addUserToDatabase(String username) {
        return false;  // TODO: Implement this method
    }

}
