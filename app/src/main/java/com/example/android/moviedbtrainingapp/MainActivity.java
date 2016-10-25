package com.example.android.moviedbtrainingapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.moviedbtrainingapp.model.Movie;
import com.example.android.moviedbtrainingapp.model.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieRecycle;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecycle = (RecyclerView) findViewById(R.id.movieList);
        adapter = new MovieAdapter(this, loadMockedMovie());
        movieRecycle.setAdapter(adapter);
        movieRecycle.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Movie> loadMockedMovie() {
        Resources resources = getResources();
        List<Movie> loadedMovies = new ArrayList<>();
        Movie currentMovie = new Movie();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] popularity = resources.getStringArray(R.array.popularity);
        String[] avarage = resources.getStringArray(R.array.avarage);

        for (int i = 0; i < titles.length; i++) {
            currentMovie.setTitle(titles[i]);
            currentMovie.setPopularity(popularity[i]);
            currentMovie.setVote_avarage(avarage[i]);
            loadedMovies.add(currentMovie);
        }
        return loadedMovies;
    }
}























