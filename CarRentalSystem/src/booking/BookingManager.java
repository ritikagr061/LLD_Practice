package booking;

import entities.Booking;
import entities.BookingStatus;
import entities.Car;
import entities.Location;
import entities.User;

import java.time.LocalDateTime;
import java.util.*;

public class BookingManager {
    List<Booking> bookings;

    //find avail car for particular pickup and dropoff time
    //book car
    //update booking

    public static class Holder{
        private static final BookingManager instance = new BookingManager();
    }
    private BookingManager(){
        bookings = new ArrayList<>();
    }
    public static BookingManager getInstance(){
        return Holder.instance;
    }

    public Booking createBooking(String bookingId,
                                 Car car,
                                 LocalDateTime pickupTime,
                                 LocalDateTime dropOffTime,
                                 User user,
                                 Location pickupLocation,
                                 Location dropOffLocation,
                                 long amount){
        validateBookingWindow(pickupTime, dropOffTime);
        if (!isCarAvailable(car, pickupTime, dropOffTime, null)) {
            throw new IllegalStateException("Car is not available for selected time window");
        }
        validateLocation(car.getAvailablePickupLocations(), pickupLocation, "pickup");
        validateLocation(car.getAvailableDropOffLocations(), dropOffLocation, "dropoff");

        Booking booking = new Booking(bookingId, car, pickupTime, dropOffTime, user, pickupLocation, dropOffLocation, amount, BookingStatus.PENDING_PAYMENT);
        bookings.add(booking);
        user.getBookings().add(booking);
        return booking;
    }

    public List<Car> searchAvailability(List<Car> cars, LocalDateTime pickup, LocalDateTime drop){
        validateBookingWindow(pickup, drop);
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (isCarAvailable(car, pickup, drop, null)) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public boolean updateBooking(Booking booking, LocalDateTime updatedDropOffTime){
        if (!canExtendBooking(booking, updatedDropOffTime)) {
            return false;
        }
        booking.setDropOffTime(updatedDropOffTime);
        return true;
    }

    public boolean canExtendBooking(Booking booking, LocalDateTime updatedDropOffTime) {
        validateBookingWindow(booking.getPickupTime(), updatedDropOffTime);
        return isCarAvailable(booking.getCar(), booking.getDropOffTime(), updatedDropOffTime, booking);
    }

    public boolean cancelBooking(Booking booking, LocalDateTime currentTime) {
        if (booking.getStatus() != BookingStatus.CONFIRMED || !currentTime.isBefore(booking.getPickupTime())) {
            return false;
        }
        booking.cancel();
        return true;
    }

    public Booking getBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        throw new NoSuchElementException("Booking not found: " + bookingId);
    }

    private boolean isCarAvailable(Car car, LocalDateTime pickup, LocalDateTime drop, Booking ignoredBooking) {
        for (Booking booking : bookings) {
            if (booking == ignoredBooking) {
                continue;
            }
            if (booking.getCar().equals(car) && booking.blocksAvailability() && booking.overlaps(pickup, drop)) {
                return false;
            }
        }
        return true;
    }

    private void validateBookingWindow(LocalDateTime pickup, LocalDateTime drop) {
        if (pickup == null || drop == null || !pickup.isBefore(drop)) {
            throw new IllegalArgumentException("Pickup time should be before dropoff time");
        }
    }

    private void validateLocation(List<Location> allowedLocations, Location selectedLocation, String type) {
        if (!allowedLocations.contains(selectedLocation)) {
            throw new IllegalArgumentException("Invalid " + type + " location selected");
        }
    }
}
