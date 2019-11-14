package com.candraibra.catmovie2.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    private final int id;
    private Context mContext;


    public DetailViewModelFactory(int id, Context context) {
        this.id = id;
        mContext = context;
    }

    @Override
    public @NonNull
    <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new DetailViewModel(id, mContext);
    }

}