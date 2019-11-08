package com.candraibra.catmovie2.viewmodel;

import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie2.data.Movie;
import com.candraibra.catmovie2.data.Tv;
import com.candraibra.catmovie2.utils.DummyData;

public class DetailViewModel extends ViewModel {
    private Tv mTv;
    private Movie mMovie;
    private String tvId;
    private String movieId;

    public Movie getMovies() {
        for (int i = 0; i < DummyData.generateDummyMovies().size(); i++) {
            Movie movies = DummyData.generateDummyMovies().get(i);
            if (movies.getMovieId().equals(movieId)) {
                mMovie = movies;
            }
        }
        return mMovie;
    }

    public Tv getTvs() {
        for (int i = 0; i < DummyData.generateDummyTvs().size(); i++) {
            Tv tvs = DummyData.generateDummyTvs().get(i);
            if (tvs.getTvId().equals(tvId)) {
                mTv = tvs;
            }
        }
        return mTv;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
