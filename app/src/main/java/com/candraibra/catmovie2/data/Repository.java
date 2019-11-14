/*
 * *
 *  * Created by Candra Ibra Sanie on 11/14/19 9:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/14/19 9:05 PM
 *
 */

package com.candraibra.catmovie2.data;

import android.app.Application;
import android.content.Context;

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

    // constructor for movieById and tvById
    public Repository(int id, Context context) {
        NetworkCall.getMovieById(id);
        NetworkCall.getTvById(id);
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
