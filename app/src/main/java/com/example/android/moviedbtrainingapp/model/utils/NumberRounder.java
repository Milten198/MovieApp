package com.example.android.moviedbtrainingapp.model.utils;


public class NumberRounder {
    public static String twoDecimalNumbers(double numberToRound) {
        return String.format("%.2f", numberToRound);
    }
}
