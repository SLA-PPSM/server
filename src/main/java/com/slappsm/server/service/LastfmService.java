package com.slappsm.server.service;

import com.slappsm.server.domain.lastfm.Friend;
import com.slappsm.server.domain.lastfm.Profile;
import com.slappsm.server.domain.lastfm.Song;

import java.io.IOException;
import java.util.List;

public interface LastfmService {
    Profile getProfile(String nick) throws IOException;
    List<Song> getRecentTracks(String nick) throws IOException;
    Song getCurrentTrack(String nick) throws IOException;
    List<Friend> getFriends(String nick) throws IOException;
}
