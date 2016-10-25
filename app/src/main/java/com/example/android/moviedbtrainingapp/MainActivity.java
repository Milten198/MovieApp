package com.example.android.moviedbtrainingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.moviedbtrainingapp.model.adapter.MovieAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieRecycle;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecycle = (RecyclerView) findViewById(R.id.movieList);
        adapter = new MovieAdapter(this);
        movieRecycle.setAdapter(adapter);
        movieRecycle.setLayoutManager(new LinearLayoutManager(this));
    }
}
