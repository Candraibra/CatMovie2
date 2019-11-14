/*
 * *
 *  * Created by Candra Ibra Sanie on 11/14/19 9:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/14/19 9:05 PM
 *
 */

package com.candraibra.catmovie2.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.viewmodel.DetailViewModel;
import com.candraibra.catmovie2.viewmodel.DetailViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.Objects;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie_id";
    private ImageView imgPoster;
    private TextView tvTitle, tvDesc;
    private ShimmerFrameLayout shimmer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        MovieResults selectedMovie;
        selectedMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        DetailViewModelFactory factory = new DetailViewModelFactory(Objects.requireNonNull(selectedMovie).getId(), getApplicationContext());
        DetailViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel.class);
        ImageButton btnBack = findViewById(R.id.backButton);
        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        shimmer = findViewById(R.id.shimmerLayout);
        btnBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        if (selectedMovie.getId() != 0) {
            viewModel.getMovieById().observe(this, results -> {
                shimmer.stopShimmer();
                shimmer.setVisibility(View.GONE);
                Glide.with(this).load("https://image.tmdb.org/t/p/w780" + results.getBackdropPath()).into(imgPoster);
                tvDesc.setText(results.getOverview());
                tvTitle.setText(results.getTitle());
            });
        } else {
            Log.d("DetailMovie", "movie id = 0");
        }


    }

}
