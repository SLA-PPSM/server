package com.slappsm.server.domain.genius;

public class Lyrics {
    int id;
    String lyrics;

    public Lyrics() {
    }

    public Lyrics(int id, String lyrics) {
        this.id = id;
        this.lyrics = lyrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
