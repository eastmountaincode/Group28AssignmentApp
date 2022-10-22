package com.example.group28assignmentapp;

import android.media.Image;

public class Entry {
    private String songTitle;
    private String artistName;
    private String rank;

    public Entry(String songTitle, String artistName, String rank) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.rank = rank;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.songTitle + "\n" + this.artistName + "\n" + "Rank = " + this.rank;
    }
}
