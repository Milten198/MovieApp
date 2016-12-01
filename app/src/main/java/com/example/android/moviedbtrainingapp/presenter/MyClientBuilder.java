package com.example.android.moviedbtrainingapp.presenter;


import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MyClientBuilder {

    protected static OkHttpClient configureClient() {
        OkHttpClient client = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(180, TimeUnit.SECONDS);
        builder.addNetworkInterceptor(new StethoInterceptor());
        client = builder.build();
        return client;
    }

    public static OkHttpClient createClient() {
        return configureClient();
    }
}
