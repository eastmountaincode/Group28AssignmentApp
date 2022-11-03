package com.example.group28assignmentapp.database;

public class User {
    public String username;
    public String message;


    public User(){
        // Default constructor necessary for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String message){
        this.username = username;
        this.message = message;
    }
}
