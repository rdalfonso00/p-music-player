package com.example.p_musicplayer.model;

import java.io.Serializable;
import java.util.LinkedList;

public class Playlist<S> implements Serializable {
    private int icon;
    private String name;
    private LinkedList<S> songs;

    public Playlist(int icon, String name, LinkedList<S> songs) {
        this.icon = icon;
        this.name = name;
        this.songs = songs;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public LinkedList<S> getSongs() {
        return songs;
    }
}
