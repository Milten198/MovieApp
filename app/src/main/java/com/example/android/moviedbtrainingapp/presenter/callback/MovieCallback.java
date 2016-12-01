package com.example.android.moviedbtrainingapp.presenter.callback;


import com.example.android.moviedbtrainingapp.model.details.MovieDetailsResponse;
import com.example.android.moviedbtrainingapp.model.general.MoviesResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieCallback {

    @GET("movie/{orderBy}")
    Observable<MoviesResponse> getMovies(@Path("orderBy") String orderBy, @Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{id}")
    Observable<MovieDetailsResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
