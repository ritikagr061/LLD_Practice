package entities;

public class Location {
    String city;
    String Address;

    public Location(String city, String address) {
        this.city = city;
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
