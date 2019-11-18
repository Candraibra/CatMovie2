/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 10:56 AM
 *
 */

package com.candraibra.catmovie2.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie2.data.Repository;
import com.candraibra.catmovie2.data.network.movie.MovieResults;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private Repository repository;

    MovieViewModel(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<MovieResults>> mLiveMovieData() {
        return repository.mLiveMovieData();
    }

}
