package com.example.android.moviedbtrainingapp.model.utils.details;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class MovieGenres implements Serializable {

    @Expose
    private
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
