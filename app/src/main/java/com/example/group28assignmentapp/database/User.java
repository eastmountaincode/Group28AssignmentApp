package com.example.group28assignmentapp.database;

import java.util.List;

public class User {
    private String username;
    private String message;
    private List<Sticker> received;
    private List<Sticker> sent;


    public User(){
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String message){
        this.username = username;
        this.message = message;
    }

    /*
    Public getters for fields allow us to add custom User Objects to the Realtime DB
     */
    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public List<Sticker> getReceived() {
        return received;
    }

    public List<Sticker> getSent() {
        return sent;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", received=" + received +
                ", sent=" + sent +
                '}';
    }
}
