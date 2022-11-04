package com.example.group28assignmentapp.database;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Sticker> received;
    private List<Sticker> sent;

    public User(){
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username){
        this.username = username;
        this.received = new ArrayList<>();
        this.sent = new ArrayList<>();
    }

    /*
    Public getters for fields allow us to add custom User Objects to the Realtime DB
     */
    public String getUsername() {
        return username;
    }

    public List<Sticker> getReceived() {
        return received;
    }

    public List<Sticker> getSent() {
        return sent;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReceived(List<Sticker> received) {
        this.received = received;
    }

    public void setSent(List<Sticker> sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", received=" + received +
                ", sent=" + sent +
                '}';
    }
}
