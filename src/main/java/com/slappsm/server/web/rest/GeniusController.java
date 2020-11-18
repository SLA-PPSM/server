package com.slappsm.server.web.rest;

import com.slappsm.server.domain.genius.Lyrics;
import com.slappsm.server.domain.genius.Result;
import com.slappsm.server.service.GeniusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/genius")
public class GeniusController {
    private final GeniusService geniusService;

    public GeniusController(GeniusService geniusService) {
        this.geniusService = geniusService;
    }

    @CrossOrigin
    @GetMapping("/search/{query}")
    public ResponseEntity<List<Result>> search(@PathVariable String query) {
        final List<Result> recentTracks = geniusService.search(query);
        return new ResponseEntity<>(recentTracks, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getLyrics/{id}")
    public ResponseEntity<Lyrics> search(@PathVariable int id) {
        final Lyrics lyrics = geniusService.getLyrics(id);
        return new ResponseEntity<>(lyrics, HttpStatus.OK);
    }
}
