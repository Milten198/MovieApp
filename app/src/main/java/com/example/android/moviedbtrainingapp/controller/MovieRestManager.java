package com.example.android.moviedbtrainingapp.controller;


import com.example.android.moviedbtrainingapp.model.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRestManager {

    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .client(MyClientBuilder.createClient())
                    .build();
        }
        return retrofit;
    }
}
