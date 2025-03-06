package entitites;

import java.util.ArrayList;
import java.util.List;

public class User {
    public Integer userId;
    public String name;
    public String drivingLicenseId;
    public List<BookingTicket> userBookings;

    public User(Integer userId, String name, String drivingLicenseId) {
        this.userId = userId;
        this.name = name;
        this.drivingLicenseId = drivingLicenseId;
        userBookings = new ArrayList<>();
    }

    public void addBooking(BookingTicket booking){
        userBookings.add(booking);
    }
}
