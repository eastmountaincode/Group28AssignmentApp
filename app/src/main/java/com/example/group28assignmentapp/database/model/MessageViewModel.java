package com.example.group28assignmentapp.database.model;


import androidx.lifecycle.ViewModel;

public class MessageViewModel extends ViewModel {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
