package com.example.group28assignmentapp.database;

import java.util.Map;

public class User {
    private String username;
    private Map<Integer, SentMessage> sentMessages;
    private Map<Integer, ReceivedMessage> receivedMessages;

    public User(){
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username,
                Map<Integer, SentMessage> sentMessages,
                Map<Integer, ReceivedMessage> receivedMessages){
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
