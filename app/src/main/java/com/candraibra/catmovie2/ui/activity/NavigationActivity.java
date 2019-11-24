/*
 * *
 *  * Created by Candra Ibra Sanie on 11/24/19 5:41 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/23/19 5:50 PM
 *
 */

package com.candraibra.catmovie2.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.ui.fragment.MovieFragment;
import com.candraibra.catmovie2.ui.fragment.TvFragment;
import com.candraibra.catmovie2.viewmodel.NavigationViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {
    final Fragment fragmentMovie = new MovieFragment();
    final Fragment fragmentTv = new TvFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentMovie;
    private NavigationViewModel viewModel;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_movies:
                fm.beginTransaction().hide(active).show(fragmentMovie).commit();
                viewModel.currentPage = 0;
                active = fragmentMovie;
                return true;

            case R.id.navigation_tv:
                fm.beginTransaction().hide(active).show(fragmentTv).commit();
                viewModel.currentPage = 1;
                active = fragmentTv;
                return true;

        }
        return false;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        viewModel = ViewModelProviders.of(this).get(NavigationViewModel.class);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().add(R.id.nav_container, fragmentTv, "Tv").hide(fragmentTv).commit();
        fm.beginTransaction().add(R.id.nav_container, fragmentMovie, "Movie").commit();
        if (viewModel.currentPage == 0) {
            fm.beginTransaction().hide(active).show(fragmentMovie).commit();
            active = fragmentMovie;
        } else {
            fm.beginTransaction().hide(active).show(fragmentTv).commit();
            active = fragmentTv;

        }

    }

}
