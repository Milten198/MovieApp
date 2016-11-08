package com.example.android.moviedbtrainingapp.model.callback;


import com.example.android.moviedbtrainingapp.model.utils.details.MovieDetailsResponse;
import com.example.android.moviedbtrainingapp.model.utils.general.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieCallback {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{id}")
    Call<MovieDetailsResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
