package com.example.thegerman.movieflicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    String posterPath;
    String originalTitle;
    String overview;
    String backdropPath;


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }


    // Constructor to convert JSON object into a Java class instance
    public Movie(JSONObject jsonObject){
        try {
            this.posterPath = jsonObject.getString("poster_path");
            this.originalTitle = jsonObject.getString("original_title");
            this.overview = jsonObject.getString("overview");
            this.backdropPath = jsonObject.getString("backdrop_path");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    // Factory method to convert an array of JSON objects into a list of objects
    // User.fromJson(jsonArray);
    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();
        for (int i = 0; i < array.length(); i++){
            try {
                results.add(new Movie(array.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }
}
