package com.example.group28assignmentapp.database;


import java.util.List;

public class User {
    private String username;
    private List<Sticker> sent;
    private List<Sticker> received;

    public User() {
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username,
                List<Sticker> sentStickers,
                List<Sticker> receivedStickers) {
        this.username = username;
        this.received = receivedStickers;
        this.sent = sentStickers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Sticker> getSent() {
        return sent;
    }

    public void setSent(List<Sticker> sent) {
        this.sent = sent;
    }

    public List<Sticker> getReceived() {
        return received;
    }

    public void setReceived(List<Sticker> received) {
        this.received = received;
    }
}
