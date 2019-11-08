package com.candraibra.catmovie2.viewmodel;

import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie2.data.Tv;
import com.candraibra.catmovie2.utils.DummyData;

import java.util.ArrayList;

public class TvViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public ArrayList<Tv> getTv() {
        return DummyData.generateDummyTvs();
    }
}
