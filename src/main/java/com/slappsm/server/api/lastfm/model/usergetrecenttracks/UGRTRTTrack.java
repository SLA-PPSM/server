package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import java.util.List;

public class UGRTRTTrack {
    UGRTRTTArtist artist;
    String name;
    List<UGRTRTTImage> image;
    UGRTRTTDate date;

    public UGRTRTTArtist getArtist() {
        return artist;
    }

    public void setArtist(UGRTRTTArtist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UGRTRTTImage> getImage() {
        return image;
    }

    public void setImage(List<UGRTRTTImage> image) {
        this.image = image;
    }

    public UGRTRTTDate getDate() {
        return date;
    }

    public void setDate(UGRTRTTDate date) {
        this.date = date;
    }
}
