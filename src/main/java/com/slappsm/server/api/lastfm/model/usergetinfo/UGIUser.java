package com.slappsm.server.api.lastfm.model.usergetinfo;

import java.util.List;

public class UGIUser {
    String name;
    String playcount;
    List<UGIUImage> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public List<UGIUImage> getImage() {
        return image;
    }

    public void setImage(List<UGIUImage> image) {
        this.image = image;
    }
}
