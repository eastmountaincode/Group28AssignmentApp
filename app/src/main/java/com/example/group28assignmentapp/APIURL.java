package com.example.group28assignmentapp;

public enum APIURL {
    TOPTRACKS("https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=c0355388e06690d06f415808862dc1fe&format=json"),
    TOPARTISTS("https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=c0355388e06690d06f415808862dc1fe&format=json");

    private String s;

    APIURL(String s) {
        this.s = s;
    }


    public String getValue() {
        return s;
    }
}
