package Entities;

import Observers.TicketObserver;
import Payment.AcceptPayment;
import Payment.Payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ticket {
    public Movie movie;
    public User user;
    List<TicketObserver> observers;
    public Ticket(User u,Movie m){
        user=u;
        movie=m;
        observers=new ArrayList<>();

    }

    public void doPayment(Hall hall,BookMyShowApp app){
        observers.addAll(Arrays.asList(app,hall,user));
        Payments payments= new AcceptPayment();
        boolean success=payments.doPayment(movie.price);
        if(success){
            //inform the observsers
            for(TicketObserver ob:observers)
                ob.informBooking(this);
        }
        else{
            System.out.println("Payment unsuccessful, booking failed");
        }
    }
}
