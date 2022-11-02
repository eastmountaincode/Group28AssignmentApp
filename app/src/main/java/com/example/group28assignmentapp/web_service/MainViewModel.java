package com.example.group28assignmentapp.web_service;

import androidx.lifecycle.ViewModel;

import com.example.group28assignmentapp.web_service.Category;
import com.example.group28assignmentapp.web_service.Entry;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private Category category;  // Top Tracks or Top Artist
    private ArrayList<Entry> entryList;

    public MainViewModel() {
        this.category = Category.TOP_SONGS;
        this.entryList = new ArrayList<>();
        Entry e = new Entry("No Entries Loaded", "Press GET", "");
        this.entryList.add(e);
    }

    public void setCategory(String value) {
        if (value.equals("Top Tracks")) {
            this.category = Category.TOP_SONGS;
        } else {
            this.category = Category.TOP_ARTISTS;
        }
    }

    public Category getCategory() {
        if (this.category == null) {
            this.category = Category.TOP_SONGS;
        }
        return this.category;
    }

    public ArrayList<Entry> getEntryList() {
        return this.entryList;
    }

    public void setEntryList(ArrayList<Entry> entryList) {
        this.entryList = entryList;
    }

}
