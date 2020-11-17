package com.slappsm.server.api.lastfm.model.usergetinfo;

import com.google.gson.annotations.SerializedName;

public class UGIImage {

    @SerializedName("#text")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
