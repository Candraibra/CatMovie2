/*
 * *
 *  * Created by Candra Ibra Sanie on 11/14/19 9:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/14/19 9:05 PM
 *
 */

package com.candraibra.catmovie2.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie2.data.Repository;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.data.network.tv.TvResults;

public class DetailViewModel extends ViewModel {
    private Repository repository;

    DetailViewModel(int id, Context context) {
        repository = new Repository(id, context);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<MovieResults> getMovieById() {
        return repository.mLiveMovieDataById();
    }

    public LiveData<TvResults> getTvById() {
        return repository.mLiveTvDataById();
    }
}
