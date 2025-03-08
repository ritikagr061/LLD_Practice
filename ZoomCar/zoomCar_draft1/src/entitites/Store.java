package entitites;

import Observer.BookingObserver;

import java.util.ArrayList;
import java.util.List;

public class Store implements BookingObserver {
    public List<BookingTicket> bookingTicketList;
    public List<Vehicle> vehicleList;
    public Location location;
    public Store(Location location){
        this.location=location;
        vehicleList= new ArrayList<>();
        bookingTicketList = new ArrayList<>();
    }

    public void addVehicle(Vehicle v){
        vehicleList.add(v);
    }
    //delete vehicle could also be there
    //update vehicle, where we can change pricePerHour or its status. - when certain vehicle is booked changed its status to booked
    public void addBookingTicket(BookingTicket booking){
        bookingTicketList.add(booking);
    }

    @Override
    public void handleBooking(BookingTicket t) {
        System.out.println("the store has been informed about the booking for the vehicle - "+t.vehicle.model+" "+t.vehicle.numberPlate);
        bookingTicketList.add(t);
    }
}
