package com.example.group28assignmentapp.database;

public class Sticker {
    private String associatedUser;
    private Integer sticker_number;

    public Sticker() {
        // Default constructor
    }

    public Sticker(String associatedUser, Integer sticker_number) {
        this.associatedUser = associatedUser;
        this.sticker_number = sticker_number;
    }

    public String getAssociatedUser() {
        return associatedUser;
    }

    public void setAssociatedUser(String associatedUser) {
        this.associatedUser = associatedUser;
    }

    public Integer getSticker_number() {
        return sticker_number;
    }

    public void setSticker_number(Integer sticker_number) {
        this.sticker_number = sticker_number;
    }
}
