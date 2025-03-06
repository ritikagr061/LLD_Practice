package Entities;

import enums.MovieType;

public class Movie {
    public String name;
    public String language;
    public MovieType movieType;

    public Movie(String name, String language, String movieType) {
        this.name = name;
        this.language = language;
        if(movieType.equals("3d")||movieType.equals("3D"))
            this.movieType = MovieType.ThreeDimensional;
        else this.movieType= MovieType.TwoDimensional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}
