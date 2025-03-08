package entitites;

import Observer.BookingObserver;
import enums.Status;
import enums.VehicleType;

public class Vehicle implements BookingObserver {
    public Integer securityDeposit;
    public VehicleType vType;
    public String numberPlate;
    public Integer rentPerDay;
    public Status status;
    public String model;

    public Vehicle(Integer securityDeposit, VehicleType vType, String numberPlate, Integer rentPerDay, Status status, String model) {
        this.securityDeposit = securityDeposit;
        this.vType = vType;
        this.numberPlate = numberPlate;
        this.rentPerDay = rentPerDay;
        this.status = status;
        this.model = model;
    }

    @Override
    public void handleBooking(BookingTicket t) {
        System.out.println("this vehicle has been booked");
        status=Status.Booked;
    }
}
