/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 10:27 AM
 *
 */

package com.candraibra.catmovie2.data;

import android.content.Context;

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
        NetworkCall.getPopularMovie();
        NetworkCall.getPopularTv();
    }

    public Repository(int id, Context context) {
        NetworkCall.getMovieById(id);
        NetworkCall.getTvById(id);
    }


    public static Repository getInstance(NetworkCall networkCall) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(networkCall);
        }
        return INSTANCE;
    }

    // Methods for MovieFragment
    public LiveData<List<MovieResults>> mLiveMovieData() {
        return NetworkCall.getDataMovie();
    }

    // Methods for TvFragment
    public LiveData<List<TvResults>> mLiveTvData() {
        return NetworkCall.getDataTv();
    }

    // Methods for MovieMovie
    public LiveData<MovieResults> mLiveMovieDataById() {
        return NetworkCall.getMovieDataById();
    }

    // Methods for DetailTv
    public LiveData<TvResults> mLiveTvDataById() {
        return NetworkCall.getTvByDataId();
    }

}
