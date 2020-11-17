package com.slappsm.server.web.rest;

import com.slappsm.server.domain.lastfm.Friend;
import com.slappsm.server.domain.lastfm.Profile;
import com.slappsm.server.domain.lastfm.Song;
import com.slappsm.server.service.LastfmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lastfm")
public class LastfmController {

    private final LastfmService lastfmService;

    public LastfmController(LastfmService lastfmService) {
        this.lastfmService = lastfmService;
    }

    @CrossOrigin
    @GetMapping("/getProfile/{nick}")
    public ResponseEntity<Profile> getProfile(@PathVariable String nick) throws IOException {
        final Profile profile = lastfmService.getProfile(nick);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getRecentTracks/{nick}")
    public ResponseEntity<List<Song>> getRecentTracks(@PathVariable String nick) throws IOException {
        final List<Song> recentTracks = lastfmService.getRecentTracks(nick);
        return new ResponseEntity<>(recentTracks, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getCurrentTrack/{nick}")
    public ResponseEntity<Song> getCurrentTrack(@PathVariable String nick) throws IOException {
        final Song currentSong = lastfmService.getCurrentTrack(nick);
        return new ResponseEntity<>(currentSong, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getFriends/{nick}")
    public ResponseEntity<List<Friend>> getFriends(@PathVariable String nick) throws IOException {
        final List<Friend> friends = lastfmService.getFriends(nick);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

}
