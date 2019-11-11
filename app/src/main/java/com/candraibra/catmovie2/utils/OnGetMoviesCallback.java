package com.candraibra.catmovie2.utils;

import com.candraibra.catmovie2.data.network.movie.MovieResults;

import java.util.List;


public interface OnGetMoviesCallback {
    void onSuccess(final List<MovieResults> movies);

    void onError();
}
