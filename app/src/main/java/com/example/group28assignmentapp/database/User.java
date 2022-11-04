package com.example.group28assignmentapp.database;

import java.util.ArrayList;


public class User {
    private String username;
    private ArrayList<SentMessage> sentMessages;
    private ArrayList<ReceivedMessage> receivedMessages;

    public User(){
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username,
                ArrayList<SentMessage> sentMessages,
                ArrayList<ReceivedMessage> receivedMessages){
        this.username = username;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", sent='" + sentMessages.toString() + '\'' +
                ", received=" + receivedMessages.toString() + '\'' +
                '}';
    }
}
