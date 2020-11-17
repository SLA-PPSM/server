package com.slappsm.server.api.lastfm;

import com.slappsm.server.api.lastfm.model.usergetfriends.UserGetFriends;
import com.slappsm.server.api.lastfm.model.usergetinfo.UserGetInfo;
import com.slappsm.server.api.lastfm.model.usergetrecenttracks.UserGetRecentTracks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastfmApi {

    @GET("?format=json&api_key=7ba451ac68f69c472dc036b5a7bd8306&method=user.getinfo")
    Call<UserGetInfo> getInfo(@Query("user") String nick);

    @GET("?format=json&api_key=7ba451ac68f69c472dc036b5a7bd8306&method=user.getfriends")
    Call<UserGetFriends> getFriends(@Query("user") String nick);

    @GET("?format=json&api_key=7ba451ac68f69c472dc036b5a7bd8306&method=user.getrecenttracks")
    Call<UserGetRecentTracks> getRecentTracks(@Query("user") String nick);
}