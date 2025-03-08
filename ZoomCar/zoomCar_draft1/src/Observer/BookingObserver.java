package Observer;

import entitites.BookingTicket;

public interface BookingObserver {
    void handleBooking(BookingTicket t);
}
