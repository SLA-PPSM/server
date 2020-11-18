package com.slappsm.server.api.lastfm.model.usergetfriends;

import java.util.List;

public class UGFFriends {
    List<UGFFUser> user;

    public List<UGFFUser> getUser() {
        return user;
    }

    public void setUser(List<UGFFUser> user) {
        this.user = user;
    }
}
