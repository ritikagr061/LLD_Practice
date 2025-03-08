package entitites;

import Observer.BookingObserver;
import payment.Payment;
import payment.TakePayment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingTicket {
    public Location pickupLocation;
    public Location DropOffLocation;
    public LocalDateTime pickupDateTime;
    public LocalDateTime dropOffDateTime;
    public Vehicle vehicle;

    private List<BookingObserver> observers=new ArrayList<>();

    private void informObservers(){
        for(BookingObserver o:observers)
            o.handleBooking(this);
    }

    public void addObserver(BookingObserver o){
        observers.add(o);
    }

    public void removeObserver(BookingObserver o){
        observers.remove(o);
    }

    public BookingTicket(Location pickupLocation, Location dropOffLocation, LocalDateTime pickupDateTime, LocalDateTime dropOffDateTime, Vehicle vehicle) {
        this.pickupLocation = pickupLocation;
        DropOffLocation = dropOffLocation;
        this.pickupDateTime = pickupDateTime;
        this.dropOffDateTime = dropOffDateTime;
        this.vehicle = vehicle;
    }

    public void processBooking(User u,Store s){
        observers.add(this.vehicle);
        observers.add(u);
        observers.add(s);
        long durationOfBooking=ChronoUnit.DAYS.between(pickupDateTime,dropOffDateTime);
        Payment p= new TakePayment((int) (this.vehicle.rentPerDay*durationOfBooking));
        if(p.makePayment()){
            informObservers();
        }
    }

}
