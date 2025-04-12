package Observers;

import Entities.Ticket;

public interface TicketObserver {
    public void informBooking(Ticket t);
}
