package com.slappsm.server.domain.lastfm;

public class Friend {

    private String nick;
    private String avatar;

    public Friend() {
    }

    public Friend(String nick, String avatar) {
        this.nick = nick;
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
