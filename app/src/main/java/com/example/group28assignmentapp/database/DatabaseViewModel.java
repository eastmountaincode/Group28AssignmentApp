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
import java.util.Map;
import java.util.Objects;

public class DatabaseViewModel extends ViewModel {
    private ArrayList<String> listOfUsernames;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    private final String TAG = "REALTIME-DATABASE";
    private String currentUser;
    private ArrayList<User> listOfUsers;

    public void loadUsers() {
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

                // Put data snapshot into a hashmap
                Map<String, Map<String, ArrayList<Map<String, Map<String, Integer>>>>> map = (Map<String, Map<String, ArrayList<Map<String, Map<String, Integer>>>>>) dataSnapshot.getValue();

                // Get list of usernames from hashmap
                listOfUsernames = new ArrayList<>(Objects.requireNonNull(map).keySet());

                // Parse hashmap into User class
                listOfUsers = new ArrayList<>();
                for (Map.Entry<String, Map<String, ArrayList<Map<String, Map<String, Integer>>>>> user: map.entrySet()) {

                    // Get sent and received lists
                    Map<String, ArrayList<Map<String, Map<String, Integer>>>> lists = user.getValue();

                    // Get items from received list
                    ArrayList<ReceivedMessage> receivedMessagesList = new ArrayList<>();
                    for (Map<String, Map<String, Integer>> receivedMessageEvent: lists.get("received")) {
                        if (receivedMessageEvent == null) {
                            continue;
                        }
                        receivedMessagesList.add(new ReceivedMessage(String.valueOf(receivedMessageEvent.get("sender")), Integer.valueOf(String.valueOf(receivedMessageEvent.get("sticker")))));
                    }

                    // Get items from sent list
                    ArrayList<SentMessage> sentMessagesList = new ArrayList<>();
                    for (Map<String, Map<String, Integer>> sentMessageEvent: lists.get("sent")) {
                        if (sentMessageEvent == null) {
                            continue;
                        }
                        sentMessagesList.add(new SentMessage(String.valueOf(sentMessageEvent.get("recipient")), Integer.valueOf(String.valueOf(sentMessageEvent.get("sticker")))));
                    }
                    listOfUsers.add(new User(user.getKey(), sentMessagesList, receivedMessagesList));

                }
                Log.d(TAG, listOfUsers.toString());


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
