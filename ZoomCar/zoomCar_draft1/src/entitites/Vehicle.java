package entitites;

import enums.Status;
import enums.VehicleType;

public class Vehicle {
    public Integer securityDeposit;
    public VehicleType vType;
    public String numberPlate;
    public Integer rentPerHour;
    public Status status;
    public String model;

    public Vehicle(Integer securityDeposit, VehicleType vType, String numberPlate, Integer rentPerHour, Status status, String model) {
        this.securityDeposit = securityDeposit;
        this.vType = vType;
        this.numberPlate = numberPlate;
        this.rentPerHour = rentPerHour;
        this.status = status;
        this.model = model;
    }
}
