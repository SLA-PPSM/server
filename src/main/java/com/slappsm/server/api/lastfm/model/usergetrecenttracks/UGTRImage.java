package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import com.google.gson.annotations.SerializedName;

public class UGTRImage {
    @SerializedName("#text")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
