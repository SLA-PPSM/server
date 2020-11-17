package com.slappsm.server.service.impl;

import com.slappsm.server.api.lastfm.LastfmApi;
import com.slappsm.server.api.lastfm.model.usergetfriends.UserGetFriends;
import com.slappsm.server.api.lastfm.model.usergetinfo.UGIUser;
import com.slappsm.server.api.lastfm.model.usergetinfo.UserGetInfo;
import com.slappsm.server.api.lastfm.model.usergetrecenttracks.UserGetRecentTracks;
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
    private final String defaultAvatar = "http://fastup.pl/data/mj/sla-ppsm/defaultAvatar.png";

    public LastfmServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.lastfmApi = retrofit.create(LastfmApi.class);
    }

    @Override
    public Profile getProfile(String nick) throws IOException {
        Profile profile = new Profile();

        try {
            Call<UserGetInfo> call = lastfmApi.getInfo(nick);
            UGIUser user = Objects.requireNonNull(call.execute().body()).getUser();

            profile.setNick(user.getName());
            profile.setAvatar(user.getImage().get(0).getImageUrl().equals("") ? defaultAvatar : user.getImage().get(0).getImageUrl());
            profile.setScrobbles(user.getPlaycount());
        } catch (NullPointerException e) {
            System.out.println("Something went wrong :(");
        }

        return profile;
    }

    @Override
    public List<Song> getRecentTracks(String nick) throws IOException {
        ArrayList<Song> songList = new ArrayList<>();

        Call<UserGetRecentTracks> call = lastfmApi.getRecentTracks(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getRecenttracks().getTrack().forEach(ugtrTrack -> {
                if(ugtrTrack.getDate() != null) {
                    Song song = new Song();
                    song.setArtist(ugtrTrack.getArtist().getArtistName());
                    song.setTitle(ugtrTrack.getName());
                    song.setImage(ugtrTrack.getImage().get(0).getImageUrl().equals("") ? defaultAvatar : ugtrTrack.getImage().get(0).getImageUrl());
                    song.setDate(ugtrTrack.getDate().getUts());
                    songList.add(song);
                }
            });
        } catch (NullPointerException e) {
            System.out.println("Something went wrong :(");
        }

        return songList;
    }

    @Override
    public Song getCurrentTrack(String nick) throws IOException {
        Song song = new Song();

        Call<UserGetRecentTracks> call = lastfmApi.getRecentTracks(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getRecenttracks().getTrack().forEach(ugtrTrack -> {
                if(ugtrTrack.getDate() == null) {
                    song.setArtist(ugtrTrack.getArtist().getArtistName());
                    song.setTitle(ugtrTrack.getName());
                    song.setImage(ugtrTrack.getImage().get(0).getImageUrl().equals("") ? defaultAvatar : ugtrTrack.getImage().get(0).getImageUrl());
                    song.setDate("now");
                }
            });
        } catch (NullPointerException e) {
            System.out.println("Something went wrong :(");
        }

        return song;
    }

    @Override
    public List<Friend> getFriends(String nick) throws IOException {
        ArrayList<Friend> friends = new ArrayList<>();

        Call<UserGetFriends> call = lastfmApi.getFriends(nick);
        try {
            Objects.requireNonNull(call.execute().body()).getFriends().getUser().forEach(ugfuser -> {
                Friend friend = new Friend();
                friend.setNick(ugfuser.getName());
                friend.setAvatar(ugfuser.getImage().get(0).getImageUrl().equals("") ? defaultAvatar : ugfuser.getImage().get(0).getImageUrl());
                friends.add(friend);
            });
        } catch (NullPointerException e) {
            System.out.println("Something went wrong :(");
        }

        return friends;
    }
}
