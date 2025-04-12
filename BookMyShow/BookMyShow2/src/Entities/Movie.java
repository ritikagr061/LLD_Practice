package Entities;

import enums.Dimension;

import java.time.LocalDateTime;

public class Movie {
    public String name;
    public int price;
    public int movieId;
    public String language;
    Dimension dimension;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Movie(String name, int movieId, String language, Dimension dimension, LocalDateTime startTime, LocalDateTime endTime,int pricee) {
        this.name = name;
        this.movieId = movieId;
        this.language = language;
        this.dimension = dimension;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price=pricee;
    }
}
