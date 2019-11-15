/*
 * *
 *  * Created by Candra Ibra Sanie on 11/15/19 7:06 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/15/19 7:01 AM
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
import com.candraibra.catmovie2.data.network.tv.TvResults;
import com.candraibra.catmovie2.viewmodel.DetailViewModel;
import com.candraibra.catmovie2.viewmodel.DetailViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTvActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "tv_id";
    @BindView(R.id.img_poster)
    public ImageView imgPoster;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.shimmerLayout)
    public ShimmerFrameLayout shimmer;
    @BindView(R.id.backButton)
    public ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        ButterKnife.bind(this);
        TvResults selectedTv;
        selectedTv = getIntent().getParcelableExtra(EXTRA_TV);
        DetailViewModelFactory factory = new DetailViewModelFactory(Objects.requireNonNull(selectedTv).getId(), getApplicationContext());
        DetailViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel.class);
        btnBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        if (selectedTv.getId() != 0) {
            viewModel.getTvById().observe(this, results -> {
                shimmer.stopShimmer();
                shimmer.setVisibility(View.GONE);
                Glide.with(this).load("https://image.tmdb.org/t/p/w780" + results.getBackdropPath()).into(imgPoster);
                tvDesc.setText(results.getOverview());
                tvTitle.setText(results.getName());
            });
        } else {
            Log.d("DetailMovie", "movie id = 0");
        }


    }

}

