package com.example.android.moviedbtrainingapp.model.general;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Movie implements Serializable {

    @Expose
    private
    String title;
    @Expose
    private
    double popularity;
    @Expose
    private
    double vote_average;
    @Expose
    private
    String poster_path;
    @Expose
    private
    int id;
    @Expose
    private
    int vote_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }



    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

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
}
