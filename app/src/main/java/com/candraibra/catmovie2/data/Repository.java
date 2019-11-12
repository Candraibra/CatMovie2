package com.candraibra.catmovie2.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResults;
import com.candraibra.catmovie2.service.NetworkCall;

import java.util.List;

public class Repository {
    private LiveData<List<MovieResults>> movieData;
    private LiveData<List<TvResults>> tvData;

    // constructor for movie
    public Repository(Application application) {
        NetworkCall.getPopularMovie();
        NetworkCall.getPopularTv();
    }

    // Methods for MovieFragment
    public LiveData<List<MovieResults>> mLiveMovieData() {
        movieData = NetworkCall.getDataMovie();
        return movieData;
    }

    // Methods for MovieFragment
    public LiveData<List<TvResults>> mLiveTvData() {
        tvData = NetworkCall.getDataTv();
        return tvData;
    }

}
