package com.example.group28assignmentapp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private String category;  // Top Tracks or Top Artist
    private ArrayList<Entry> entryList;

    public MainViewModel() {
        this.category = "ABC";
        this.entryList = new ArrayList<>();
        Entry e = new Entry("No Entries Loaded", "Press GET", "");
        this.entryList.add(e);
    }

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

}
