package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import com.google.gson.annotations.SerializedName;

public class UGTRArtist {
    @SerializedName("#text")
    String artistName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
