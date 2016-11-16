package com.example.android.moviedbtrainingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.controller.MovieRestManager;
import com.example.android.moviedbtrainingapp.model.callback.MovieCallback;
import com.example.android.moviedbtrainingapp.model.utils.Constants;
import com.example.android.moviedbtrainingapp.model.utils.details.MovieCompanies;
import com.example.android.moviedbtrainingapp.model.utils.details.MovieDetailsResponse;
import com.example.android.moviedbtrainingapp.model.utils.details.MovieGenres;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.moviedbtrainingapp.model.utils.Constants.MOVIE_REFERENCE.MOVIE;
import static com.example.android.moviedbtrainingapp.model.utils.NumberRounder.twoDecimalNumber;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView title, averageVote, popularity, voted, overview, tagline, genres, released, revenue, companies;
    ImageView poster;
    int movieId = 278;
    MovieDetailsResponse movieResponse;
    List<MovieGenres> genresList;
    List<MovieCompanies> companiesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
//
//        Intent intent = getIntent();
//        int dupa = intent.getIntExtra(MOVIE, 0);
        configView();

        MovieCallback callback = MovieRestManager.getClient().create(MovieCallback.class);
        Call<MovieDetailsResponse> callDetails = callback.getMovieDetails(movieId, Constants.API_KEY.API_KEY);

        callDetails.enqueue(new Callback<MovieDetailsResponse>() {
            @Override
            public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
                movieResponse = response.body();
                genresList = response.body().getGenres();
                companiesList = response.body().getProduction_companies();

                setData();
            }

            @Override
            public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {

            }
        });

    }

    private void setData() {
        title.setText(movieResponse.getOriginal_title());
        averageVote.setText("Average vote: " + twoDecimalNumber(movieResponse.getVote_average()));
        popularity.setText("Popularity: " + twoDecimalNumber(movieResponse.getPopularity()));
        voted.setText("Voted: " + movieResponse.getVote_count());
        overview.setText(movieResponse.getOverview());
        tagline.setText(movieResponse.getTagline());
        revenue.setText(movieResponse.getRevenue() + "");
        released.setText(movieResponse.getRelease_date());
        Glide.with(this).load(Constants.BACK_DROP.BACK_DROP_PATH + movieResponse.getBackdrop_path())
                .into(poster);
    }

    private void configView() {
        title = (TextView) findViewById(R.id.detailsTitle);
        averageVote = (TextView) findViewById(R.id.detailsAverage);
        popularity = (TextView) findViewById(R.id.detailsPopularity);
        voted = (TextView) findViewById(R.id.detailsVoted);
        overview = (TextView) findViewById(R.id.movieDescription);
        poster = (ImageView) findViewById(R.id.moviePoster);
        tagline = (TextView) findViewById(R.id.detailsTagline);
        genres = (TextView) findViewById(R.id.detailsGenres);
        released = (TextView) findViewById(R.id.detailsReleaseDate);
        revenue = (TextView) findViewById(R.id.detailsRevenue);
    }
}
