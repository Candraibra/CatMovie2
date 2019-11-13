package com.candraibra.catmovie2.service;

import com.candraibra.catmovie2.data.network.movie.MovieResponse;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResponse;
import com.candraibra.catmovie2.data.network.tv.TvResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    //get_movie_by_id
    @GET("movie/{movie_id}")
    Call<MovieResults> getMovieById(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

    //get_tv_by_id
    @GET("tv/{tv_id}")
    Call<TvResults> getTvById(
            @Path("tv_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

}
