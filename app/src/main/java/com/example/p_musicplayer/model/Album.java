package com.example.p_musicplayer.model;

import java.io.Serializable;

public class Album implements Serializable {
    private int icon;
    private String albumName;
    private String artistName;

    public int getYear() {
        return year;
    }

    private int year;


    public Album(int icon, String albumName, String artistName, int year) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.icon = icon;
        this.year = year;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getIcon() {
        return icon;
    }
}