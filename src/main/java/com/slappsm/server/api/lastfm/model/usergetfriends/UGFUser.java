package com.slappsm.server.api.lastfm.model.usergetfriends;

import java.util.List;

public class UGFUser {
    String name;
    List<UGFImage> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UGFImage> getImage() {
        return image;
    }

    public void setImage(List<UGFImage> image) {
        this.image = image;
    }
}
