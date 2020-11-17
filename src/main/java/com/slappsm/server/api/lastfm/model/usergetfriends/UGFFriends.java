package com.slappsm.server.api.lastfm.model.usergetfriends;

import java.util.List;

public class UGFFriends {
    List<UGFUser> user;

    public List<UGFUser> getUser() {
        return user;
    }

    public void setUser(List<UGFUser> user) {
        this.user = user;
    }
}
