package com.example.group28assignmentapp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private String currentGenre;
    private ArrayList<Song> songList;

    public MainViewModel() {}

    public void setCurrentGenre(String value) {
        this.currentGenre = value;
    }

    public String getCurrentGenre() {
        return this.currentGenre;
    }

}
