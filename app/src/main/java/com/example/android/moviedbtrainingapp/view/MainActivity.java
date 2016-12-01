package com.example.android.moviedbtrainingapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.moviedbtrainingapp.R;
import com.example.android.moviedbtrainingapp.model.general.Movie;
import com.example.android.moviedbtrainingapp.model.general.MoviesResponse;
import com.example.android.moviedbtrainingapp.model.utils.Constants;
import com.example.android.moviedbtrainingapp.presenter.MovieRestManager;
import com.example.android.moviedbtrainingapp.presenter.adapter.MovieAdapter;
import com.example.android.moviedbtrainingapp.presenter.callback.MovieCallback;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieClickListener {

    @BindView(R.id.movieList)
    RecyclerView movieRecycle;
    @BindView(R.id.recyclerProgressBar)
    ProgressBar spinner;
    private MovieAdapter adapter;
    private boolean loading = true;
    private int pastVisibleItems, visibleItemCount, totalItemCount;
    private int topRatedPage = 1;
    private int popularPage = 1;
    private int page = 1;
    private List<Movie> topRatedMovies;
    private List<Movie> popularMovies;
    private LinearLayoutManager movieLinearManager;
    private String moviesOrder = Constants.MOVIES_ORDER.TOP_MOVIES;
    @BindView(R.id.swipeIt)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());

        setContentView(R.layout.activity_main);
        topRatedMovies = new ArrayList<>();
        popularMovies = new ArrayList<>();
        ButterKnife.bind(this);
        config();
        downloadMoviesData();

        swipeRefreshLayout.setOnRefreshListener(this::downloadMoviesData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pref_movies_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.topRated) {
            moviesOrder = Constants.MOVIES_ORDER.TOP_MOVIES;
            page = topRatedPage;
            if (topRatedMovies.isEmpty()) {
                downloadMoviesData();
            } else {
                adapter.getMovies(topRatedMovies);
                adapter.notifyDataSetChanged();
            }
            return true;
        }
        if (id == R.id.mostPopular) {
            page = popularPage;
            moviesOrder = Constants.MOVIES_ORDER.POPULAR_MOVIES;
            if (popularMovies.isEmpty()) {
                downloadMoviesData();
            } else {
                adapter.getMovies(popularMovies);
                adapter.notifyDataSetChanged();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void downloadMoviesData() {
        MovieCallback callback = MovieRestManager.getClient().create(MovieCallback.class);
        Observable<MoviesResponse> movies = callback.getMovies(moviesOrder, Constants.API_KEY.API_KEY, page);
        movies.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoviesResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadingFailure();
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onNext(MoviesResponse moviesResponse) {
                        if (moviesOrder.equals(Constants.MOVIES_ORDER.TOP_MOVIES)) {
                            List<Movie> moviesList = moviesResponse.getResults();
                            topRatedMovies.addAll(moviesList);
                            endlessList(topRatedMovies);
                            topRatedPage++;
                        }
                        if (moviesOrder.equals(Constants.MOVIES_ORDER.POPULAR_MOVIES)) {
                            List<Movie> moviesList = moviesResponse.getResults();
                            popularMovies.addAll(moviesList);
                            endlessList(popularMovies);
                            popularPage++;
                        }
                        loading = false;
                        page++;
                    }
                });
    }

    public void endlessList(List<Movie> movies) {
        movieRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = movieLinearManager.getChildCount();
                    totalItemCount = movieLinearManager.getItemCount();
                    pastVisibleItems = movieLinearManager.findFirstVisibleItemPosition();

                    if (!loading) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            spinner.setVisibility(View.VISIBLE);
                            loading = true;
                            downloadMoviesData();
                        }
                    }
                }
            }
        });
        adapter.getMovies(movies);
        adapter.notifyDataSetChanged();
        spinner.setVisibility(View.GONE);
    }

    public void config() {
        movieLinearManager = new LinearLayoutManager(this);
        adapter = new MovieAdapter(this, this);
        movieRecycle.setAdapter(adapter);
        movieRecycle.setLayoutManager(movieLinearManager);
        movieRecycle.setHasFixedSize(true);
    }

    @Override
    public void itemClicked(int position) {
        Movie selectedMovie = adapter.getSelectedMovie(position);
        int movieId = selectedMovie.getId();
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(Constants.MOVIE_REFERENCE.MOVIE, movieId);
        startActivity(intent);
    }

    public void loadingFailure() {
        Toast.makeText(getApplicationContext(), "Failed to load data. Check your Internet connection", Toast.LENGTH_LONG).show();
        spinner.setVisibility(View.GONE);
        loading = false;
    }

}























