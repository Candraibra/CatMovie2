package com.candraibra.catmovie2.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResults;
import com.candraibra.catmovie2.service.NetworkCall;

import java.util.List;

public class Repository {
    // constructor for movie
    public Repository(Application application) {
        NetworkCall.getPopularMovie();
        NetworkCall.getPopularTv();
    }

    // Methods for MovieFragment
    public LiveData<List<MovieResults>> mLiveMovieData() {
        return NetworkCall.getDataMovie();
    }

    // Methods for MovieFragment
    public LiveData<List<TvResults>> mLiveTvData() {
        return NetworkCall.getDataTv();
    }

}
