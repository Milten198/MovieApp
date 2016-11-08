package com.example.android.moviedbtrainingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.model.Movie;
import com.example.android.moviedbtrainingapp.model.utils.Constants;
import com.example.android.moviedbtrainingapp.model.utils.NumberRounder;

import static com.example.android.moviedbtrainingapp.model.utils.Constants.MOVIE_REFERENCE.MOVIE;
import static com.example.android.moviedbtrainingapp.model.utils.NumberRounder.twoDecimalNumber;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView title, averageVote, popularity, voted, overview;
    ImageView poster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra(MOVIE);
        configView();

        title.setText(movie.getTitle());
        averageVote.setText("Average vote: " + twoDecimalNumber(movie.getVote_average()));
        popularity.setText("Popularity: " + twoDecimalNumber(movie.getPopularity()));
        voted.setText("Voted: " + movie.getVote_count());
        overview.setText(movie.getOverview());
        Glide.with(this).load(Constants.BACK_DROP.BACK_DROP_PATH + movie.getBackdrop_path())
                .into(poster);
    }

    private void configView() {
        title = (TextView) findViewById(R.id.detailsTitle);
        averageVote = (TextView) findViewById(R.id.detailsAverage);
        popularity = (TextView) findViewById(R.id.detailsPopularity);
        voted = (TextView) findViewById(R.id.detailsVoted);
        overview = (TextView) findViewById(R.id.movieDescription);
        poster = (ImageView) findViewById(R.id.moviePoster);
    }
}
