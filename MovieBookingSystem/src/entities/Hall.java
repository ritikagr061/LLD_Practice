package entities;

import java.util.List;

public class Hall {
    private int hallNumber;
    private List<Seat> seats;

    public Hall(int hallNumber, List<Seat> seats) {
        this.hallNumber = hallNumber;
        this.seats = seats;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
