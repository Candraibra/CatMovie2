package com.candraibra.catmovie2.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.candraibra.catmovie2.data.Repository;
import com.candraibra.catmovie2.data.network.movie.MovieResults;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private Repository repository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
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
