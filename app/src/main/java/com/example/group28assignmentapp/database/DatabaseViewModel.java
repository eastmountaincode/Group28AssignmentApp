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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DatabaseViewModel extends ViewModel {
    private ArrayList<String> listOfUsernames;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    private final String TAG = "REALTIME-DATABASE";
    private String currentUser;
//    Map<User, ReceivedMessage> userReceived = new HashMap<>();
//    Map<User, SentMessage> userSent = new HashMap<>();




    public void loadUsernames() {
        // TODO: load the usernames from the database into listOfUsernames so we can
        // check if the one the user enters exists, or if the user wants to create a NEW user,
        // we must check that that username doesn't already exist

        // Want app data to update in real time when the database updates.
        // To do this, we add an event listener the the mUsers reference above:
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                // loop all the data
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    User user = new User();
//                    SentMessage sent = new SentMessage();
//                    ReceivedMessage received = new ReceivedMessage();
//                    user.setUsername(snapshot.getKey());
//                    // loop data encapsulated in "received"
//                    for (DataSnapshot ds : snapshot.child("received").getChildren()){
//                        received.setSender(ds.getValue(ReceivedMessage.class).getSender());
//                        received.setStickerId(ds.getValue(ReceivedMessage.class).getStickerId());
//
//                        //  mapping User class and  ReceivedMessage class
//                        // using getter methods to get relevant data
//                        userReceived.put(user, received);
//                    }
//
//                    // loop data encapsulated in "sent"
//                    for (DataSnapshot ds : snapshot.child("sent").getChildren()){
//                        sent.setRecipient((ds.getValue(SentMessage.class).getRecipient()));
//                        sent.setStickerId((ds.getValue(SentMessage.class).getStickerId()));
//                        //  mapping User class and SentMessage class
//                        // using getter methods to get relevant data
//                        userSent.put(user, sent);
//                    }
//
//                }
//                // the code is to check if the data is store successfully into maps line 66 - 70
//                // - Yikan
//                for (Map.Entry<User, ReceivedMessage> entry : userReceived.entrySet()){
//                    String testUserName = entry.getKey().getUsername();
//                    String testSenderName = entry.getValue().getSender();
//                    int testStickerId = entry.getValue().getStickerId();
//                    String debug = "xxxx";
//                }

                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                // Put data snapshot into a hashmap
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Log.d(TAG, "UserMap value is: " + map);
                // Get list of usernames from hashmap
                listOfUsernames = new ArrayList<>(Objects.requireNonNull(map).keySet());
                Log.d(TAG, "Usernames are: " + listOfUsernames);
                // Parse hashmap into User class



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
