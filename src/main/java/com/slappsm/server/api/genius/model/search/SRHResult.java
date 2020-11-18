package com.slappsm.server.api.genius.model.search;

public class SRHResult {
    int id;
    String title;
    SRHRPrimaryArtist primary_artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SRHRPrimaryArtist getPrimary_artist() {
        return primary_artist;
    }

    public void setPrimary_artist(SRHRPrimaryArtist primary_artist) {
        this.primary_artist = primary_artist;
    }
}
