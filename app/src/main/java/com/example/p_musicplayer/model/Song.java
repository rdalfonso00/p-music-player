package com.example.p_musicplayer.model;

public class Song {
    private int icon;
    private String title;
    private String artistName;
    private String albumName;
    private int year;
    private int trackNumber;
    private String Genre;

    // mp specific attributes
    private boolean isFavorite;

    public Song(int icon, String songTitle, String artistName, String albumName) {
        this.icon = icon;
        this.title = songTitle;
        this.artistName = artistName;
        this.albumName = albumName;
    }
    public Song(int icon, String songTitle, String artistName, String albumName,boolean isFavorite) {
        this.icon = icon;
        this.title = songTitle;
        this.artistName = artistName;
        this.isFavorite = isFavorite;
        this.albumName = albumName;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getYear() {
        return year;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getGenre() {
        return Genre;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
