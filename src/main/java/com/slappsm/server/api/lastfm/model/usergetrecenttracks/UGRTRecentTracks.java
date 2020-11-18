package com.slappsm.server.api.lastfm.model.usergetrecenttracks;

import java.util.List;

public class UGRTRecentTracks {
    List<UGRTRTTrack> track;

    public List<UGRTRTTrack> getTrack() {
        return track;
    }

    public void setTrack(List<UGRTRTTrack> track) {
        this.track = track;
    }
}
