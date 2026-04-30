package app;

import InventoryManager.InventoryManager;
import booking.BookingManager;
import entities.Booking;
import entities.BookingStatus;
import entities.Car;
import entities.Location;
import entities.User;
import payment.CardPayment;
import payment.CashPayment;
import payment.PaymentMode;
import payment.PaymentService;
import pricing.HighDemandPricing;
import pricing.PricingStrategy;
import pricing.StandardPricing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CarRentalFacade {
    private List<User> users;
    private InventoryManager inventoryManager;
    private BookingManager bookingManager;
    private PricingStrategy pricingStrategy;
    private AtomicLong bookingIdCounter;

    public CarRentalFacade(){
        users = new ArrayList<>();
        users.add(new User(1,"ritik", new ArrayList<>()));
        users.add(new User(2,"bunty", new ArrayList<>()));

        inventoryManager = InventoryManager.getInstance();
        bookingManager = BookingManager.getInstance();
        pricingStrategy = new StandardPricing();
        bookingIdCounter = new AtomicLong(1);
    }

    public List<Car> searchCars(String city, LocalDateTime pickupTime, LocalDateTime dropOffTime){
        List<Car> relevantCityCars = inventoryManager.searchCityCars(city);
        return bookingManager.searchAvailability(relevantCityCars, pickupTime, dropOffTime);
    }

    public Booking createBooking(int userId,
                                 Car car,
                                 LocalDateTime pickupTime,
                                 LocalDateTime dropOffTime,
                                 Location pickupLocation,
                                 Location dropOffLocation,
                                 PaymentMode paymentMode){
        User user = getUser(userId);
        long price = pricingStrategy.calcPrice(car, pickupTime, dropOffTime);
        String bookingId = "B" + bookingIdCounter.getAndIncrement();

        Booking booking = bookingManager.createBooking(
                bookingId,
                car,
                pickupTime,
                dropOffTime,
                user,
                pickupLocation,
                dropOffLocation,
                price
        );

        PaymentService paymentService = getPaymentService(paymentMode);
        if (paymentService.pay(price)) {
            booking.confirm();
        } else {
            booking.cancel();
        }
        return booking;
    }

    public boolean cancelBooking(String bookingId, LocalDateTime currentTime) {
        Booking booking = bookingManager.getBooking(bookingId);
        return bookingManager.cancelBooking(booking, currentTime);
    }

    public boolean extendBooking(String bookingId, LocalDateTime updatedDropOffTime, PaymentMode paymentMode) {
        Booking booking = bookingManager.getBooking(bookingId);
        if (booking.getStatus() != BookingStatus.CONFIRMED && booking.getStatus() != BookingStatus.IN_PROGRESS) {
            return false;
        }

        long oldAmount = booking.getAmount();
        long updatedAmount = pricingStrategy.calcPrice(booking.getCar(), booking.getPickupTime(), updatedDropOffTime);
        long extraAmount = updatedAmount - oldAmount;
        if (extraAmount <= 0) {
            return false;
        }

        if (!bookingManager.canExtendBooking(booking, updatedDropOffTime)) {
            return false;
        }

        PaymentService paymentService = getPaymentService(paymentMode);
        if (!paymentService.pay(extraAmount)) {
            return false;
        }

        bookingManager.updateBooking(booking, updatedDropOffTime);
        booking.setAmount(updatedAmount);
        return true;
    }

    public void startTrip(String bookingId) {
        bookingManager.getBooking(bookingId).startTrip();
    }

    public void completeTrip(String bookingId) {
        bookingManager.getBooking(bookingId).completeTrip();
    }

    public void useHighDemandPricing() {
        pricingStrategy = new HighDemandPricing();
    }

    public void useStandardPricing() {
        pricingStrategy = new StandardPricing();
    }

    public User getUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        throw new NoSuchElementException("User not found: " + userId);
    }

    private PaymentService getPaymentService(PaymentMode paymentMode) {
        if (paymentMode == PaymentMode.CASH) {
            return new CashPayment();
        }
        return new CardPayment();
    }
}
