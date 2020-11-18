package com.slappsm.server.api.lastfm.model.usergetfriends;

import com.google.gson.annotations.SerializedName;

public class UGFFUImage {

    @SerializedName("#text")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
