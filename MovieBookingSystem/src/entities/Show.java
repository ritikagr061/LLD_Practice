package entities;

import java.time.LocalDateTime;

public class Show {
    private String movieName;
    private int hallNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Show(String movieName, int hallNumber, LocalDateTime startTime, LocalDateTime endTime) {
        this.movieName = movieName;
        this.hallNumber = hallNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
