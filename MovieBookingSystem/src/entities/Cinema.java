package entities;

import java.util.List;

public class Cinema {
    private List<Hall> halls;
    private List<Show> shows;
    private String city;

    public Cinema(List<Hall> halls, List<Show> shows, String city) {
        this.halls = halls;
        this.shows = shows;
        this.city = city;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
