package com.example.android.moviedbtrainingapp.model;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Movie implements Serializable {

    @Expose
    String title;
    @Expose
    double popularity;
    @Expose
    double vote_average;
    @Expose
    String backdrop_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
