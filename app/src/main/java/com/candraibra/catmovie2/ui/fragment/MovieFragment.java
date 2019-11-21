/*
 * *
 *  * Created by Candra Ibra Sanie on 11/21/19 10:49 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/21/19 10:49 AM
 *
 */

package com.candraibra.catmovie2.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.adapter.MovieAdapter;
import com.candraibra.catmovie2.ui.activity.DetailMovieActivity;
import com.candraibra.catmovie2.utils.ItemClickSupport;
import com.candraibra.catmovie2.viewmodel.MovieViewModel;
import com.candraibra.catmovie2.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends Fragment {
    @BindView(R.id.rv_movie)
    public RecyclerView recyclerView;
    @BindView(R.id.shimmerLayout)
    public ShimmerFrameLayout shimmer;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            MovieViewModel viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel.class);
            viewModel.mLiveMovieData().observe(this, results -> {
                shimmer.stopShimmer();
                shimmer.setVisibility(View.GONE);
                MovieAdapter movieAdapter = new MovieAdapter(getActivity(), results);
                if (results != null) {
                    ItemClickSupport.addTo(recyclerView).setOnItemClickListener((recyclerView, position, v) -> {
                        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, results.get(position));
                        startActivity(intent);
                    });
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(movieAdapter);
                    movieAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "List Null", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
