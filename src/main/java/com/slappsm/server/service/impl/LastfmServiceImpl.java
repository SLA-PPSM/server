package com.slappsm.server.service.impl;

import com.slappsm.server.api.lastfm.LastfmApi;
import com.slappsm.server.api.lastfm.model.usergetfriends.LAUserGetFriends;
import com.slappsm.server.api.lastfm.model.usergetinfo.UGIUser;
import com.slappsm.server.api.lastfm.model.usergetinfo.LAUserGetInfo;
import com.slappsm.server.api.lastfm.model.usergetrecenttracks.LAUserGetRecentTracks;
import com.slappsm.server.domain.lastfm.Friend;
import com.slappsm.server.domain.lastfm.Profile;
import com.slappsm.server.domain.lastfm.Song;
import com.slappsm.server.service.LastfmService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LastfmServiceImpl implements LastfmService {

    private final LastfmApi lastfmApi;
    private final String defaultAvatar = "https://i.imgur.com/uhSjztl.jpg";
    private final String defaultCover = "https://i.imgur.com/8G1vjFP.jpg";

    public LastfmServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.lastfmApi = retrofit.create(LastfmApi.class);
    }

    @Override
    public Profile getProfile(String nick) {
        Profile profile = new Profile();

        try {
            Call<LAUserGetInfo> call = lastfmApi.getInfo(nick);
            UGIUser user = Objects.requireNonNull(call.execute().body()).getUser();
            profile.setNick(user.getName());
            profile.setAvatar(user.getImage().get(2).getImageUrl().equals("") ? defaultAvatar : user.getImage().get(2).getImageUrl());
            profile.setScrobbles(user.getPlaycount());
        } catch (NullPointerException | IOException e) {
            System.out.println("Something went wrong :(");
        }

        return profile;
    }

    @Override
    public List<Song> getRecentTracks(String nick) {
        ArrayList<Song> songList = new ArrayList<>();

        Call<LAUserGetRecentTracks> call = lastfmApi.getRecentTracks(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getRecenttracks().getTrack().forEach(ugtrTrack -> {
                if(ugtrTrack.getDate() != null) {
                    Song song = new Song();
                    song.setArtist(ugtrTrack.getArtist().getArtistName());
                    song.setTitle(ugtrTrack.getName());
                    song.setImage(ugtrTrack.getImage().get(2).getImageUrl().equals("") ? defaultCover : ugtrTrack.getImage().get(2).getImageUrl());
                    song.setDate(ugtrTrack.getDate().getUts());
                    songList.add(song);
                }
            });
        } catch (NullPointerException | IOException e) {
            System.out.println("Something went wrong :(");
        }

        return songList;
    }

    @Override
    public Song getCurrentTrack(String nick) {
        Song song = new Song();

        Call<LAUserGetRecentTracks> call = lastfmApi.getRecentTracks(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getRecenttracks().getTrack().forEach(ugtrTrack -> {
                if(ugtrTrack.getDate() == null) {
                    song.setArtist(ugtrTrack.getArtist().getArtistName());
                    song.setTitle(ugtrTrack.getName());
                    song.setImage(ugtrTrack.getImage().get(2).getImageUrl().equals("") ? defaultCover : ugtrTrack.getImage().get(2).getImageUrl());
                    song.setDate("now");
                }
            });
        } catch (NullPointerException | IOException e) {
            System.out.println("Something went wrong :(");
        }

        return song;
    }

    @Override
    public List<Friend> getFriends(String nick) {
        ArrayList<Friend> friends = new ArrayList<>();

        Call<LAUserGetFriends> call = lastfmApi.getFriends(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getFriends().getUser().forEach(ugfuser -> {
                Friend friend = new Friend();
                friend.setNick(ugfuser.getName());
                friend.setAvatar(ugfuser.getImage().get(2).getImageUrl().equals("") ? defaultAvatar : ugfuser.getImage().get(2).getImageUrl());
                friends.add(friend);
            });
        } catch (NullPointerException | IOException e) { 
            System.out.println("Something went wrong :(");
        }

        return friends;
    }
}
