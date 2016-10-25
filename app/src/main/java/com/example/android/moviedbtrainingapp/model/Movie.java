package com.example.android.moviedbtrainingapp.model;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Movie implements Serializable {

    @Expose
    String title;
    @Expose
    String popularity;
    @Expose
    String vote_avarage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_avarage() {
        return vote_avarage;
    }

    public void setVote_avarage(String vote_avarage) {
        this.vote_avarage = vote_avarage;
    }
}
