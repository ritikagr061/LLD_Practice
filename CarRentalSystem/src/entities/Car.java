package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private String numberPlate;
    private Location location;
    private CarStatus status;
    private int rentPerDay;
    private List<Location> availablePickupLocations;
    private List<Location> availableDropOffLocations;

    @Override
    public String toString() {
        return model + " [" + numberPlate + "] at " + location + " - $" + rentPerDay + "/day";
    }
}
