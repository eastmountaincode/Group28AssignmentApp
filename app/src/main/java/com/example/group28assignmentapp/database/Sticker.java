package com.example.group28assignmentapp.database;

public class Sticker {
    private String associatedUser;
    private int sticker_number;

    public Sticker(String sender, int stickerID) {
        this.associatedUser = sender;
        this.sticker_number = stickerID;
    }

    public void setAssociatedUser(String associatedUser) {
        this.associatedUser = associatedUser;
    }

    public void setStickerId(int stickerId) {
        this.sticker_number = stickerId;
    }

    public String getAssociatedUser() {
        return associatedUser;
    }

    public int getStickerId() {
        return sticker_number;
    }
}
