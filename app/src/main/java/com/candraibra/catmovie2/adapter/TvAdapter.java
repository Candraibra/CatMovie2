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

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.data.local.entity.Tv;
import com.candraibra.catmovie2.ui.activity.DetailTvActivity;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Tv> tvArrayList;

    public TvAdapter(Activity activity) {
        this.activity = activity;
    }

    private ArrayList<Tv> getTvArrayList() {
        return tvArrayList;
    }

    public void setTvArrayList(ArrayList<Tv> tvArrayList) {
        this.tvArrayList = tvArrayList;
    }


    @NonNull
    @Override
    public TvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.MyViewHolder holder, int i) {
        holder.tvTitle.setText(tvArrayList.get(i).getTitle());
        holder.tvDesc.setText(tvArrayList.get(i).getDesc());
        holder.imgPhoto.setImageResource(tvArrayList.get(i).getImage());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailTvActivity.class);
            intent.putExtra(DetailTvActivity.EXTRA_TV, getTvArrayList().get(i).getTvId());
            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return tvArrayList.size();
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
