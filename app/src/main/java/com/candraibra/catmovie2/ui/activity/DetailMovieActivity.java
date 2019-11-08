package com.candraibra.catmovie2.ui.activity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.data.Movie;
import com.candraibra.catmovie2.viewmodel.DetailViewModel;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    private ImageView imgPoster;
    private TextView tvDesc;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        //viewModel
        DetailViewModel viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        //init views
        ImageButton btnBack = findViewById(R.id.backButton);

        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        //btnBackOnClick
        btnBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            if (movieId != null) {
                viewModel.setMovieId(movieId);
            }
            if (viewModel.getMovies() != null) {
                makeView(viewModel.getMovies());
            }

        }
    }

    private void makeView(Movie movie) {
        imgPoster.setImageResource(movie.getImage());
        tvDesc.setText(movie.getDesc());
        tvTitle.setText(movie.getTitle());
    }
}
