package com.example.android.moviedbtrainingapp.model.utils;


public class Constants {

    public static final class HTTP {
        public static final String BASE_URL = "https://api.themoviedb.org/3/";
    }

    public static final class API_KEY {
        public static final String API_KEY = "api_key";
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

    public static final class MOVIES_ORDER {
        public static final String TOP_MOVIES = "top_rated";
        public static final String POPULAR_MOVIES = "popular";
    }
}
