package com.example.group28assignmentapp.database;

public class ReceivedMessage {
    private String sender;
    private int stickerID;

    public ReceivedMessage(String sender, int stickerID) {
        this.sender = sender;
        this.stickerID = stickerID;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setStickerId(int stickerId) {
        this.stickerID = stickerId;
    }

    public String getSender() {
        return sender;
    }

    public int getStickerId() {
        return stickerID;
    }
}
