package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import java.util.List;

public class UGTRTrack {
    UGTRArtist artist;
    String name;
    List<UGTRImage> image;
    UGTRDate date;

    public UGTRArtist getArtist() {
        return artist;
    }

    public void setArtist(UGTRArtist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UGTRImage> getImage() {
        return image;
    }

    public void setImage(List<UGTRImage> image) {
        this.image = image;
    }

    public UGTRDate getDate() {
        return date;
    }

    public void setDate(UGTRDate date) {
        this.date = date;
    }
}
