package com.slappsm.server.domain.lastfm;

public class Song {

    private String artist;
    private String title;
    private String image;
    private String date;

    public Song() {
    }

    public Song(String artist, String title, String image, String date) {
        this.artist = artist;
        this.title = title;
        this.image = image;
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
