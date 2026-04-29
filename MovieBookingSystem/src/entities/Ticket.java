package entities;

public class Ticket {
    private Show show;
    private Seat seat;
    private int price;

    public Ticket(Seat seat, Show show) {
        this.seat = seat;
        this.show = show;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
