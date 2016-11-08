package com.example.android.moviedbtrainingapp.model.utils;


import com.example.android.moviedbtrainingapp.model.data.MovieContract;
import com.example.android.moviedbtrainingapp.model.data.MovieContract.MovieData;

public class Constants {

    public static final class HTTP {
        public static final String BASE_URL = "https://api.themoviedb.org/3/";
    }

    public static final class API_KEY {
        public static final String API_KEY = "8757222b80658879874f4a7a63d8bfb3";
    }

    public static final class BACK_DROP {
        public static final String BACK_DROP_PATH = "https://image.tmdb.org/t/p/w500/";
    }

    public static final class MOVIE_REFERENCE {
        public static final String MOVIE = Config.PACKAGE_NAME + "movie";
    }

    public static final class Config {
        public static final String PACKAGE_NAME = "com.example.android.moviedbtrainingapp";
    }

    public static final class MOVIE_TABLE {
        public static final String TABLE_NAME = "CREATE TABLE " + MovieData.TABLE_NAME + " (" +
                MovieData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MovieData.COLUMN_TITLE + " TEXT NOT NULL, " +
                MovieData.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
                MovieData.COLUMN_AVARAGE + " REAL NOT NULL, " +
                MovieData.COLUMN_POPULARITY + " REAL NOT NULL, " +
                MovieData.COLUMN_POSTER + " TEXT NOT NULL, " +
                MovieData.COLUMN_BACKDROP + " TEXT NOT NULL" +
                ");";
    }
}
