package com.example.group28assignmentapp.database;

public class Sent {
    String recipient;
    int stickerId;

    public Sent(){

    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setStickerId(int stickerId) {
        this.stickerId = stickerId;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getStickerId() {
        return stickerId;
    }
}
