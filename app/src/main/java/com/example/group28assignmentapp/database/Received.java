package com.example.group28assignmentapp.database;

public class Received {
    String sender;
    int stickerId;

    public Received() {

    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setStickerId(int stickerId) {
        this.stickerId = stickerId;
    }

    public String getSender() {
        return sender;
    }

    public int getStickerId() {
        return stickerId;
    }
}
