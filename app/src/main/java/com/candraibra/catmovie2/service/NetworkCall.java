package com.candraibra.catmovie2.service;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.candraibra.catmovie2.BuildConfig;
import com.candraibra.catmovie2.data.network.movie.MovieResponse;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
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

    private TMDBApi apiClient = ApiClient.getClient().create(TMDBApi.class);


    public void getPopularMovie() {

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
}
