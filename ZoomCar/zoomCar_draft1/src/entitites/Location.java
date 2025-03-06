package entitites;

import java.util.Scanner;

public class Location {
    public String address;
    public Integer pinCode;
    public String city;

    public Location(String address, Integer pinCode, String city) {
        this.address = address;
        this.pinCode = pinCode;
        this.city = city;
    }
    public Location inputLocation(){
        Scanner sc=new Scanner(System.in);
        System.out.println("type address");
        String add = sc.next();
        System.out.println("type pincode");
        Integer pin=sc.nextInt();
        System.out.println("type city");
        String city=sc.next();
        return new Location(add,pin,city);
    }
}
