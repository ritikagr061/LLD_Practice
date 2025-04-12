package Entities;

import Observers.TicketObserver;

import java.util.ArrayList;
import java.util.List;

public class User implements TicketObserver {
    int userId;
    String userName;
    List<Ticket> bookingHistory;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        bookingHistory=new ArrayList<>();
    }

    @Override
    public void informBooking(Ticket t) {
        bookingHistory.add(t);
    }
}
