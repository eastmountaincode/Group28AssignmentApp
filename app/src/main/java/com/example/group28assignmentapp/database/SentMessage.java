package com.example.group28assignmentapp.database;

public class SentMessage {
    private String recipient;
    private int stickerId;

    public SentMessage(String recipient, int stickerId) {
        this.recipient = recipient;
        this.stickerId = stickerId;
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
