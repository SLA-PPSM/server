package com.slappsm.server.service;

import com.slappsm.server.domain.lastfm.Friend;
import com.slappsm.server.domain.lastfm.Profile;
import com.slappsm.server.domain.lastfm.Song;

import java.util.List;

public interface LastfmService {
    Profile getProfile(String nick);
    List<Song> getRecentTracks(String nick);
    Song getCurrentTrack(String nick);
    List<Friend> getFriends(String nick);
}
