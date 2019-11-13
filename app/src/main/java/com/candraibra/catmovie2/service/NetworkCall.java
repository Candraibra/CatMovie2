package com.candraibra.catmovie2.service;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.candraibra.catmovie2.BuildConfig;
import com.candraibra.catmovie2.data.network.movie.MovieResponse;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResponse;
import com.candraibra.catmovie2.data.network.tv.TvResults;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {

    private static final String LANGUAGE = "en-US";
    private static MutableLiveData<List<MovieResults>> movieData = new MutableLiveData<>();
    private static MutableLiveData<List<TvResults>> tvData = new MutableLiveData<>();

    private static MutableLiveData<MovieResults> movieDataById = new MutableLiveData<>();
    private static MutableLiveData<TvResults> tvDataById = new MutableLiveData<>();

    private static TMDBApi apiClient = ApiClient.getClient().create(TMDBApi.class);


    public static void getPopularMovie() {
        Call<MovieResponse> call = apiClient.getMoviePopular(BuildConfig.ApiKey, LANGUAGE, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getResults() != null) {
                        movieData.postValue(moviesResponse.getResults());
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
    }


    public static void getPopularTv() {
        Call<TvResponse> tvResponseCall = apiClient.getTvPopular(BuildConfig.ApiKey, LANGUAGE, 1);
        tvResponseCall.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvResponse> call, @NotNull Response<TvResponse> response) {
                if (response.isSuccessful()) {
                    TvResponse tvResponse = response.body();
                    if (tvResponse != null && tvResponse.getResults() != null) {
                        tvData.postValue(tvResponse.getResults());
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
    }

    public static void getMovieById(int id) {
        Call<MovieResults> movieResultsCall = apiClient.getMovieById(id, BuildConfig.ApiKey, LANGUAGE);
        movieResultsCall.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(@NotNull Call<MovieResults> call, @NotNull Response<MovieResults> response) {
                if (response.isSuccessful()) {
                    MovieResults movieResults = response.body();
                    if (movieResults != null) {
                        movieDataById.postValue(movieResults);
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResults> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
    }


    public static void getTvById(int id) {
        Call<TvResults> tvResultsCall = apiClient.getTvById(id, BuildConfig.ApiKey, LANGUAGE);
        tvResultsCall.enqueue(new Callback<TvResults>() {
            @Override
            public void onResponse(@NotNull Call<TvResults> call, @NotNull Response<TvResults> response) {
                if (response.isSuccessful()) {
                    TvResults tvResults = response.body();
                    if (tvResults != null) {
                        tvDataById.postValue(tvResults);
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvResults> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
    }

    public static LiveData<List<MovieResults>> getDataMovie() {
        return movieData;
    }

    public static LiveData<List<TvResults>> getDataTv() {
        return tvData;
    }

    public static LiveData<MovieResults> getMovieDataById() {
        return movieDataById;
    }

    public static LiveData<TvResults> getTvByDataId() {
        return tvDataById;
    }


}
