package entities;

public class Seat {
    private int seatNumber;
    private SeatLevel level;

    public Seat(int seatNumber, SeatLevel level) {
        this.seatNumber = seatNumber;
        this.level = level;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatLevel getLevel() {
        return level;
    }

    public void setLevel(SeatLevel level) {
        this.level = level;
    }
}
