package com.example.fragments.Config;

import com.example.fragments.Model.Film.Favorites;
import com.example.fragments.Model.Film.FavFilmRequest;
import com.example.fragments.Model.Film.FavFilmResponse;
import com.example.fragments.Model.Film.searchFilmModel;
import com.example.fragments.Model.List.ListModel;
import com.example.fragments.Model.List.ListResponse;
import com.example.fragments.Model.List.Lists;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("search/movie?")
    Call<searchFilmModel> getData(@Query("api_key") String api_key, @Query("query") String query);

    @GET("account/cf18jordi")
    Call<Favorites> getFavData(@Query("api_key") String api_key, @Query("session_id") String session_id);

    @POST("account/cf18jordi")
    Call<FavFilmResponse> postFavMovie(@Query("api_key") String api_key, @Query("session_id") String session_id, @Body FavFilmRequest favFilmRequest);

    @POST("list?")
    Call<ListResponse> postList(@Query("api_key") String api_key, @Query("session_id") String session_id, @Body ListModel listModel);

    @GET("account/cf18jordi")
    Call<Lists> getLists(@Query("api_key") String api_key, @Query("session_id") String session_id);



}