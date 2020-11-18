package com.slappsm.server.api.genius;

import com.slappsm.server.api.genius.model.lyrics.GALyrics;
import com.slappsm.server.api.genius.model.search.GASearch;
import retrofit2.Call;
import retrofit2.http.*;

public interface GeniusApi {
    @GET("https://api.genius.com/search/?access_token=8JEddJLmToPqzJXlTN-dTMdvZDubK16xQ_jSls01TwLgddmruFL1iDbjgGkRNvIp")
    Call<GASearch> getSearchResults(@Query("q") String query);

    @Headers("Cookie: _rapgenius_session=BAh7CToPc2Vzc2lvbl9pZEkiJTgyMmNjOTMzYzQ3ZTk1ZjI1MGE1ZTRjZTExNThkZTZmBjoGRUY6EF9jc3JmX3Rva2VuSSIxUDQ1Nk9tM1UxaFNUYStCdFVzem10TTA4NkoyUkhtbzkyWVkyeGZPaWlaaz0GOwZGSSIVdXNlcl9jcmVkZW50aWFscwY7BlRJIgGAZjljOWQ1NGFhYmM3NTdjODAyMjc0YWFjZjliYmM2MjM3OTkwMjAxOWE3NTBlOTQ0YjQ0ZGFhYzA5YTlkNTc0NWI5OGM5YTczNWRjZmRiZWZiYjhjMDNmNmEzODMzNzMzNmViNDkxYjlkNTU3MzFiNTlhM2FlNTVmNzJlOGJlZmQGOwZUSSIYdXNlcl9jcmVkZW50aWFsc19pZAY7BlRpA1i7aA%3D%3D--f8b09e8e3117f698d56c642a0a0f6766d2c2c73e")
    @GET("https://genius.com/api/songs/{id}/lyrics_for_edit_proposal")
    Call<GALyrics> getLyrics(@Path("id") int id);
}
