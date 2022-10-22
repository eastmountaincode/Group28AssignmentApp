package com.example.group28assignmentapp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private String category;  // Top Tracks or Top Artist
    private ArrayList<Entry> entryList;

    public MainViewModel() {}

    public void setCategory(String value) {
        this.category = value;
    }

    public String getCategory() {
        return this.category;
    }

    public ArrayList<Entry> getEntryList() {
        return this.entryList;
    }

    public void setEntryList(ArrayList<Entry> entryList) {
        this.entryList = entryList;
    }

    public void setSong(Entry song) {
        this.entryList.add(song);
    }
}
