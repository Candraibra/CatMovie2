package com.candraibra.catmovie2.ui.fragment;

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
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.viewmodel.MovieViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class MovieFragment extends Fragment {

    RecyclerView recyclerView;
    ShimmerFrameLayout shimmer;

    private MovieAdapter movieAdapter = new MovieAdapter(getActivity());

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movie);
        shimmer = view.findViewById(R.id.shimmerLayout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            MovieViewModel viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
            viewModel.mLiveMovieData().observe(this, results -> {
                shimmer.stopShimmer();
                shimmer.setVisibility(View.GONE);
                setupRecyclerView(results);
                movieAdapter.setMovieList(results);
            });
        }
    }

    private void setupRecyclerView(List<MovieResults> results) {
        if (results != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(movieAdapter);
            movieAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getActivity(), "List Null", Toast.LENGTH_SHORT).show();
        }
    }

}
