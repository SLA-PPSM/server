package com.slappsm.server.domain.lastfm;

import java.util.List;

public class RecentTracks {

    private List<Song> songList;

    public RecentTracks() {
    }

    public RecentTracks(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
