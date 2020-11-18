package com.slappsm.server.service.impl;

import com.slappsm.server.api.genius.GeniusApi;
import com.slappsm.server.api.genius.model.lyrics.GALyrics;
import com.slappsm.server.api.genius.model.search.SRHit;
import com.slappsm.server.api.genius.model.search.GASearch;
import com.slappsm.server.api.lastfm.model.usergetinfo.UGIUser;
import com.slappsm.server.domain.genius.Lyrics;
import com.slappsm.server.domain.genius.Result;
import com.slappsm.server.service.GeniusService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GeniusServiceImpl implements GeniusService {
    private final GeniusApi geniusApi;

    public GeniusServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.genius.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.geniusApi = retrofit.create(GeniusApi.class);
    }

    @Override
    public List<Result> search(String query) {
        ArrayList<Result> results = new ArrayList<>();

        Call<GASearch> call = geniusApi.getSearchResults(query);
        try {
            Objects.requireNonNull(call.execute().body()).getResponse().getHits().stream().map(SRHit::getResult).forEach(sResult -> {
                Result result = new Result();
                result.setId(sResult.getId());
                result.setArtist(sResult.getPrimary_artist().getName());
                result.setTitle(sResult.getTitle());
                results.add(result);
            });
        } catch (NullPointerException | IOException e) {
            System.out.println("Something went wrong :(");
        }

        return results;
    }

    @Override
    public Lyrics getLyrics(int id) {
        Lyrics lyrics = new Lyrics();

        try {
            Call<GALyrics> call = geniusApi.getLyrics(id);
            GALyrics gaLyrics = Objects.requireNonNull(call.execute().body());
            lyrics.setId(id);
            lyrics.setLyrics(gaLyrics.getResponse().getLyrics_for_edit_proposal().getBody().getPlain());
        } catch (NullPointerException | IOException e) {
            System.out.println("Something went wrong :(");
        }

        return lyrics;
    }
}
