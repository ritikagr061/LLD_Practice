package entitites;

import java.time.LocalDateTime;

public class BookingTicket {
    public Location pickupLocation;
    public Location DropOffLocation;
    public LocalDateTime pickupDateTime;
    public LocalDateTime dropOffDateTime;
    public Vehicle vehicle;

    public BookingTicket(Location pickupLocation, Location dropOffLocation, LocalDateTime pickupDateTime, LocalDateTime dropOffDateTime, Vehicle vehicle) {
        this.pickupLocation = pickupLocation;
        DropOffLocation = dropOffLocation;
        this.pickupDateTime = pickupDateTime;
        this.dropOffDateTime = dropOffDateTime;
        this.vehicle = vehicle;
    }
}
