package com.example.group28assignmentapp.database;

public class Sticker {
    private String associatedUser;
    private int stickerNumber;

    public Sticker(String sender, int stickerID) {
        this.associatedUser = sender;
        this.stickerNumber = stickerID;
    }

    public void setAssociatedUser(String associatedUser) {
        this.associatedUser = associatedUser;
    }

    public void setStickerId(int stickerId) {
        this.stickerNumber = stickerId;
    }

    public String getAssociatedUser() {
        return associatedUser;
    }

    public int getStickerId() {
        return stickerNumber;
    }
}
