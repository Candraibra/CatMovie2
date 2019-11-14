/*
 * *
 *  * Created by Candra Ibra Sanie on 11/14/19 9:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/14/19 9:05 PM
 *
 */

package com.candraibra.catmovie2.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.candraibra.catmovie2.data.Repository;
import com.candraibra.catmovie2.data.network.tv.TvResults;

import java.util.List;

public class TvViewModel extends AndroidViewModel {
    private Repository repository;

    public TvViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<TvResults>> mLiveTvData() {
        return repository.mLiveTvData();
    }

}
