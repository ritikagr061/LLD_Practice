package entitites;

public class Location {
    public String address;
    public Integer pinCode;
    public String city;

    public Location(String address, Integer pinCode, String city) {
        this.address = address;
        this.pinCode = pinCode;
        this.city = city;
    }
}
