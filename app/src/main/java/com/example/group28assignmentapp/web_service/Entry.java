package com.example.group28assignmentapp.web_service;

public class Entry {
    private String title;
    private String subtitle;
    private String rank;

    public Entry(String title, String subtitle, String rank) {
        this.title = title;
        this.subtitle = subtitle;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.title + "\n" + this.subtitle + "\n" + "Rank = " + this.rank;
    }
}
