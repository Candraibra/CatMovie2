package com.candraibra.catmovie2.ui.activity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.data.local.Tv;
import com.candraibra.catmovie2.viewmodel.DetailViewModel;

public class DetailTvActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";

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
            String tvId = extras.getString(EXTRA_TV);
            if (tvId != null) {
                viewModel.setTvId(tvId);
            }
            if (viewModel.getTvs() != null) {
                makeView(viewModel.getTvs());
            }

        }
    }

    private void makeView(Tv tv) {
        imgPoster.setImageResource(tv.getImage());
        tvDesc.setText(tv.getDesc());
        tvTitle.setText(tv.getTitle());
    }
}

