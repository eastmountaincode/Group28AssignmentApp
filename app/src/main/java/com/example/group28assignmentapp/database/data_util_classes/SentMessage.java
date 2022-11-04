package com.example.group28assignmentapp.database.data_util_classes;

public class SentMessage {
    private String recipient;
    private Integer stickerID;

    public SentMessage(String recipient, int stickerId) {
        this.recipient = recipient;
        this.stickerID = stickerId;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setStickerId(int stickerId) {
        this.stickerID = stickerId;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getStickerId() {
        return stickerID;
    }

    public String toString() {
        return "Recipient: " + this.recipient.toString() + " " + "StickerID: " + this.stickerID.toString();
    }
}
