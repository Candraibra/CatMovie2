package com.candraibra.catmovie2.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.candraibra.catmovie2.R;
import com.candraibra.catmovie2.adapter.TvAdapter;
import com.candraibra.catmovie2.data.Tv;
import com.candraibra.catmovie2.viewmodel.TvViewModel;

import java.util.ArrayList;

public class TvFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
        if (getActivity() != null) {
            //define viewModel
            TvViewModel mViewModel = ViewModelProviders.of(this).get(TvViewModel.class);
            ArrayList<Tv> tvs = mViewModel.getTv();

            //adapter
            TvAdapter tvAdapter = new TvAdapter(getActivity());
            tvAdapter.setTvArrayList(tvs);

            //recyclerView
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvAdapter);
        }
    }

}
