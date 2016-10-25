package com.example.android.moviedbtrainingapp.model.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    LayoutInflater inflater;
    Context context;
    List<Movie> mockMovies = Collections.EMPTY_LIST;

    public MovieAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieView = inflater.inflate(R.layout.activity_main, parent, false);
        MovieHolder holder = new MovieHolder(movieView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MovieHolder extends RecyclerView.ViewHolder {

        public MovieHolder(View itemView) {
            super(itemView);
        }
    }
}
