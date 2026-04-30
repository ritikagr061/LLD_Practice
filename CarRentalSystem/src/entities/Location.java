package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String city;
    private int pinCode;
    private String address;

    @Override
    public String toString() {
        return address + ", " + city + " - " + pinCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Location)) {
            return false;
        }
        Location location = (Location) object;
        return pinCode == location.pinCode
                && Objects.equals(city, location.city)
                && Objects.equals(address, location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, pinCode, address);
    }
}
