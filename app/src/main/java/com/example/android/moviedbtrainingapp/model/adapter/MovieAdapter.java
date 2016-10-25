package com.example.android.moviedbtrainingapp.model.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    LayoutInflater inflater;
    Context context;
    List<Movie> mockMovies;

    public MovieAdapter(Context context, List<Movie> movies) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.mockMovies = movies;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieView = inflater.inflate(R.layout.movie_item, parent, false);
        MovieHolder holder = new MovieHolder(movieView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie currentMovie = mockMovies.get(position);
        holder.titleView.setText(currentMovie.getTitle());
        holder.popularityView.setText(currentMovie.getPopularity());
        holder.avarageView.setText(currentMovie.getVote_avarage());
    }

    @Override
    public int getItemCount() {
        return mockMovies.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {

        TextView titleView, popularityView, avarageView;

        public MovieHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.movieTitle);
            popularityView = (TextView) itemView.findViewById(R.id.moviePopularity);
            avarageView = (TextView) itemView.findViewById(R.id.movieAvarageVote);
        }
    }
}
