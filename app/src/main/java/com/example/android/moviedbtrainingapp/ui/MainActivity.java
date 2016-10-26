package com.example.android.moviedbtrainingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.controller.MovieRestManager;
import com.example.android.moviedbtrainingapp.model.Movie;
import com.example.android.moviedbtrainingapp.model.MoviesResponse;
import com.example.android.moviedbtrainingapp.model.adapter.MovieAdapter;
import com.example.android.moviedbtrainingapp.model.callback.MovieCallback;
import com.example.android.moviedbtrainingapp.model.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieClickListener {

    RecyclerView movieRecycle;
    MovieAdapter adapter;
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadMoviesData();
    }

    public void downloadMoviesData() {
        MovieCallback callback = MovieRestManager.getClient().create(MovieCallback.class);
        Call<MoviesResponse> call = callback.getTopRatedMovies(Constants.API_KEY.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> moviesList = response.body().getResults();
                setAdapter(moviesList);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void setAdapter(List<Movie> movies) {
        movieRecycle = (RecyclerView) findViewById(R.id.movieList);
        adapter = new MovieAdapter(this, this);
        adapter.getMovies(movies);
        movieRecycle.setAdapter(adapter);
        movieRecycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void itemClicked(int position) {
        Movie selectedMovie = adapter.getSelectedMovie(position);
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(Constants.MOVIE_REFERENCE.MOVIE, selectedMovie);
        startActivity(intent);
    }
}























