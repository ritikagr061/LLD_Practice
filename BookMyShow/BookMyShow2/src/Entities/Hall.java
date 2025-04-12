package Entities;

import Observers.TicketObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Hall implements TicketObserver {
    public String city;
    public String address;
    List<List<Seat>> seatingArrangement;
    List<Ticket> bookings=new ArrayList<>();
    List<Movie> schedule;

    public Hall(String city, String address, List<List<Seat>> seatingArrangement, List<Movie> schedule) {
        this.city = city;
        this.address = address;
        this.seatingArrangement = seatingArrangement;
        this.schedule = schedule;
    }

    @Override
    public void informBooking(Ticket t) {
        System.out.println("ticket booking is informed to the cinema hall");
        bookings.add(t);
    }
}
