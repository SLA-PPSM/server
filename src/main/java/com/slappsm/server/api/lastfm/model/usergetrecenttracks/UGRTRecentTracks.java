package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import java.util.List;

public class UGRTRecentTracks {
    List<UGTRTrack> track;

    public List<UGTRTrack> getTrack() {
        return track;
    }

    public void setTrack(List<UGTRTrack> track) {
        this.track = track;
    }
}
