package com.candraibra.catmovie2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.data.network.movie.MovieResults;
import com.candraibra.catmovie2.ui.activity.DetailMovieActivity;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Activity activity;
    private List<MovieResults> movieList;

    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieResults> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieResults> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int i) {
        holder.tvTitle.setText(movieList.get(i).getTitle());
        holder.tvDesc.setText(movieList.get(i).getOverview());
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath()).placeholder(R.drawable.loading).into(holder.imgPhoto);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, DetailMovieActivity.class);
//                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getMovieList().get(i).getId());
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDesc;
        ImageView imgPhoto;

        MyViewHolder(View view) {
            super(view);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.iv_poster);

        }
    }
}