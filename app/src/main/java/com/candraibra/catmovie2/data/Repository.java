/*
 * *
 *  * Created by Candra Ibra Sanie on 11/24/19 5:41 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/24/19 5:27 PM
 *
 */

package com.candraibra.catmovie2.data;

import androidx.lifecycle.LiveData;

import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResults;
import com.candraibra.catmovie2.service.NetworkCall;

import java.util.List;

public class Repository {
    private static Repository INSTANCE;
    private NetworkCall networkCall;

    private Repository(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public static Repository getInstance(NetworkCall networkCall) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(networkCall);
        }
        return INSTANCE;
    }

    // Methods for MovieFragment
    public LiveData<List<MovieResults>> mLiveMovieData() {
        return networkCall.getPopularMovie();
    }

    // Methods for TvFragment
    public LiveData<List<TvResults>> mLiveTvData() {
        return networkCall.getPopularTv();
    }

    // Methods for MovieMovie
    public LiveData<MovieResults> mLiveMovieDataById(Integer id) {
        return networkCall.getMovieById(id);
    }

    // Methods for DetailTv
    public LiveData<TvResults> mLiveTvDataById(Integer id) {
        return networkCall.getTvById(id);
    }

}
