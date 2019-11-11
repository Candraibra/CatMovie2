package com.candraibra.catmovie2.data.local.entity;

public class Movie {
    private String movieId;
    private String title;
    private String desc;
    private int image;

    public Movie(String movieId, String title, String desc, int image) {
        this.movieId = movieId;
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getMovieId() {
        return movieId;
    }


    public String getTitle() {
        return title;
    }



    public String getDesc() {
        return desc;
    }



    public int getImage() {
        return image;
    }



}
