package com.example.group28assignmentapp.database;


import java.util.List;

public class User {
    private String username;
    private List<Sticker> sentStickers;
    private List<Sticker> receivedStickers;

    public User() {
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username,
                List<Sticker> sentStickers,
                List<Sticker> receivedStickers) {
        this.username = username;
        this.receivedStickers = receivedStickers;
        this.sentStickers = sentStickers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Sticker> getSentStickers() {
        return sentStickers;
    }

    public void setSentStickers(List<Sticker> sentStickers) {
        this.sentStickers = sentStickers;
    }

    public List<Sticker> getReceivedStickers() {
        return receivedStickers;
    }

    public void setReceivedStickers(List<Sticker> receivedStickers) {
        this.receivedStickers = receivedStickers;
    }
}
