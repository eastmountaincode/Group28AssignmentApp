package com.example.group28assignmentapp;

import android.media.Image;

public class Song {
    private String songTitle;
    private String artistName;
    private String rank;
    private Image albumArt;

    public Song(String songTitle, String artistName, String rank, Image albumArt) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.rank = rank;
        this.albumArt = albumArt;
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

    public Image getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(Image albumArt) {
        this.albumArt = albumArt;
    }
}
