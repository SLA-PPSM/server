package com.slappsm.server.service;

import com.slappsm.server.domain.genius.Lyrics;
import com.slappsm.server.domain.genius.Result;

import java.util.List;

public interface GeniusService {
    List<Result> search(String query);
    Lyrics getLyrics(int id);
}
