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

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.android.moviedbtrainingapp.model.utils.Constants.MOVIE_REFERENCE.MOVIE;
import static com.example.android.moviedbtrainingapp.model.utils.NumberRounder.twoDecimalNumber;

public class MovieDetailsActivity extends AppCompatActivity {


    @BindView(R.id.detailsTitle)
    TextView title;
    @BindView(R.id.detailsAverage)
    TextView averageVote;
    @BindView(R.id.detailsPopularity)
    TextView popularity;
    @BindView(R.id.detailsVoted)
    TextView voted;
    @BindView(R.id.movieDescription)
    TextView overview;
    @BindView(R.id.detailsTagline)
    TextView tagline;
    @BindView(R.id.detailsGenres)
    TextView genres;
    @BindView(R.id.detailsReleaseDate)
    TextView released;
    @BindView(R.id.detailsRevenue)
    TextView revenue;
    @BindView(R.id.detailsCompanies)
    TextView companies;
    @BindView(R.id.moviePoster)
    ImageView poster;

    int movieId;
    MovieDetailsResponse movieResponse;
    List<MovieGenres> genresList;
    List<MovieCompanies> companiesList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        movieId = intent.getIntExtra(MOVIE, 278);

        MovieCallback callback = MovieRestManager.getClient().create(MovieCallback.class);

        Observable<MovieDetailsResponse> movieDetails = callback.getMovieDetails(movieId, Constants.API_KEY.API_KEY);
        movieDetails.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetailsResponse>() {
                    @Override
                    public void onCompleted() {
                        setData();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieDetailsResponse movieDetailsResponse) {
                        movieResponse = movieDetailsResponse;
                        genresList = movieDetailsResponse.getGenres();
                        companiesList = movieDetailsResponse.getProduction_companies();
                    }
                });
    }

    private void setData() {
        Glide.with(this).load(Constants.BACK_DROP.BACK_DROP_PATH + movieResponse.getBackdrop_path())
                .into(poster);
        title.setText(movieResponse.getOriginal_title());
        averageVote.setText("Average vote: " + twoDecimalNumber(movieResponse.getVote_average()));
        popularity.setText("Popularity: " + twoDecimalNumber(movieResponse.getPopularity()));
        voted.setText("Voted: " + movieResponse.getVote_count());
        overview.setText(movieResponse.getOverview());
        tagline.setText(movieResponse.getTagline());
        revenue.setText("Revenue: " + revenueFormat(movieResponse.getRevenue()));
        released.setText("Released: " + movieResponse.getRelease_date());
        genres.setText("Genres: " + fillGenres(genresList));
        companies.setText("Production companies: " + fillCompanies(companiesList));
    }

    private String fillGenres(List<MovieGenres> movieGenres) {
        String genres = null;
        for (MovieGenres mg : movieGenres) {
            genres = mg.getName() + " ";
        }
        return genres;
    }

    private String fillCompanies(List<MovieCompanies> movieCompanies) {
        String companies = null;
        for (MovieCompanies mc : movieCompanies) {
            companies = mc.getName() + " ";
        }
        return companies;
    }

    private String revenueFormat(int revenue) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        format.setCurrency(Currency.getInstance(Locale.US));
        return format.format(revenue);
    }


}
