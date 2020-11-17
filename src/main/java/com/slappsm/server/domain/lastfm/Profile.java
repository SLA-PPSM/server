package com.slappsm.server.domain.lastfm;

public class Profile {

    private String nick;
    private String avatar;
    private String scrobbles;

    public Profile() {
    }

    public Profile(String nick, String avatar, String scrobbles) {
        this.nick = nick;
        this.avatar = avatar;
        this.scrobbles = scrobbles;
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

    public String getScrobbles() {
        return scrobbles;
    }

    public void setScrobbles(String scrobbles) {
        this.scrobbles = scrobbles;
    }

}
