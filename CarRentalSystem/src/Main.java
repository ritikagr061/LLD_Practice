import app.CarRentalFacade;
import entities.Booking;
import entities.Car;
import payment.PaymentMode;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarRentalFacade facade = new CarRentalFacade();

        LocalDateTime pickupTime = LocalDateTime.of(2026, 5, 1, 10, 0);
        LocalDateTime dropOffTime = LocalDateTime.of(2026, 5, 3, 10, 0);

        List<Car> availableCars = facade.searchCars("Delhi", pickupTime, dropOffTime);
        System.out.println("Available cars: " + availableCars);

        Car selectedCar = availableCars.get(0);
        Booking booking = facade.createBooking(
                1,
                selectedCar,
                pickupTime,
                dropOffTime,
                selectedCar.getAvailablePickupLocations().get(0),
                selectedCar.getAvailableDropOffLocations().get(0),
                PaymentMode.CARD
        );

        System.out.println("Created booking: " + booking);

        boolean extended = facade.extendBooking(
                booking.getBookingId(),
                LocalDateTime.of(2026, 5, 4, 10, 0),
                PaymentMode.CARD
        );
        System.out.println("Booking extended: " + extended);
        System.out.println("Updated booking: " + booking);

        facade.startTrip(booking.getBookingId());
        facade.completeTrip(booking.getBookingId());
        System.out.println("Completed booking: " + booking);
    }
}
