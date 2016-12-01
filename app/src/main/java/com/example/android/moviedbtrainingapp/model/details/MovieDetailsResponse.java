package com.example.android.moviedbtrainingapp.model.details;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class MovieDetailsResponse implements Serializable {

    @Expose
    private String backdrop_path;
    @Expose
    private
    List<MovieGenres> genres;
    @Expose
    private
    List<MovieCompanies> production_companies;
    @Expose
    private
    String original_title;
    @Expose
    private
    double popularity;
    @Expose
    private
    double vote_average;
    @Expose
    private
    int vote_count;
    @Expose
    private
    String release_date;
    @Expose
    private
    String tagline;
    @Expose
    private
    String overview;
    @Expose
    private
    int revenue;

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<MovieGenres> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenres> genres) {
        this.genres = genres;
    }

    public List<MovieCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<MovieCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
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

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
