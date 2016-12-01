package com.example.android.moviedbtrainingapp.presenter.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.model.general.Movie;

import java.util.Collections;
import java.util.List;

import static com.example.android.moviedbtrainingapp.model.utils.Constants.BACK_DROP;
import static com.example.android.moviedbtrainingapp.model.utils.NumberRounder.twoDecimalNumbers;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    LayoutInflater inflater;
    Context context;
    List<Movie> movies = Collections.EMPTY_LIST;
    MovieClickListener movieListener;

    public MovieAdapter(Context context, MovieClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.movieListener = listener;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieView = inflater.inflate(R.layout.movie_item, parent, false);
        MovieHolder holder = new MovieHolder(movieView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        holder.titleView.setText(currentMovie.getTitle());
        holder.popularityView.setText("Popularity: " + twoDecimalNumbers(currentMovie.getPopularity()));
        holder.avarageView.setText("Average vote: " + twoDecimalNumbers(currentMovie.getVote_average()));
        Glide.with(context).load(BACK_DROP.BACK_DROP_PATH + currentMovie.getPoster_path())
                .into(holder.backDropView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void getMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getSelectedMovie(int position) {
        return movies.get(position);
    }

    class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titleView, popularityView, avarageView;
        ImageView backDropView;

        public MovieHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.movieTitle);
            popularityView = (TextView) itemView.findViewById(R.id.moviePopularity);
            avarageView = (TextView) itemView.findViewById(R.id.movieAvarageVote);
            backDropView = (ImageView) itemView.findViewById(R.id.movieImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            movieListener.itemClicked(getAdapterPosition());
        }
    }

    public interface MovieClickListener {
         void itemClicked(int position);
    }
}
