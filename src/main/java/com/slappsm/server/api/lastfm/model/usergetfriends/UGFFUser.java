package com.slappsm.server.api.lastfm.model.usergetfriends;

import java.util.List;

public class UGFFUser {
    String name;
    List<UGFFUImage> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UGFFUImage> getImage() {
        return image;
    }

    public void setImage(List<UGFFUImage> image) {
        this.image = image;
    }
}
