package entitites;

import java.util.ArrayList;
import java.util.List;

public class Store {
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
}
