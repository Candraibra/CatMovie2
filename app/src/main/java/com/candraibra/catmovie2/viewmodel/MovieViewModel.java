package com.candraibra.catmovie2.viewmodel;

import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie2.data.local.entity.Movie;
import com.candraibra.catmovie2.utils.DummyData;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public ArrayList<Movie> getMovie() {
        return DummyData.generateDummyMovies();
    }
}
