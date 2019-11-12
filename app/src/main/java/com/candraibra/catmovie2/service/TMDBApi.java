package com.candraibra.catmovie2.service;

import com.candraibra.catmovie2.data.network.movie.MovieResponse;
import com.candraibra.catmovie2.data.network.tv.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBApi {

    // query for movies

    @GET("movie/popular")
    Call<MovieResponse> getMoviePopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    // query for tvs

    @GET("tv/popular")
    Call<TvResponse> getTvPopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

}
