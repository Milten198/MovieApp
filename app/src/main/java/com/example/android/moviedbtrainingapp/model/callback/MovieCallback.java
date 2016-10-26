package com.example.android.moviedbtrainingapp.model.callback;


import com.example.android.moviedbtrainingapp.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieCallback {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
