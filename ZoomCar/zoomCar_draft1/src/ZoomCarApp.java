import entitites.*;
import enums.Status;
import enums.VehicleType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZoomCarApp {
    //create stores first by giving location , add vehicles in them
    //

    public static List<Store> storelist=new ArrayList<>();
    public static List<User> userList=new ArrayList<>();

    public User currentUser;

    private BookingTicket ticket;

    Scanner scanner = new Scanner(System.in);

    public Store optimalStore;

    public static List<Store> getStorelist() {
        return storelist;
    }

    public static void setStorelist(List<Store> storelist) {
        ZoomCarApp.storelist = storelist;
    }

    public void systemIntializer(){
        //add users
        //add stores
        //add vehicles in stores

        User u1= new User(1,"ritik","1");
        User u2 = new User(2,"bheem","2");
        userList.add(u1);
        userList.add(u2);

        Location l1= new Location("vaishali sec 6",201001,"Delhi");
        Location l2= new Location("magarpatta",30022,"Bangalore");

        Vehicle v1 = new Vehicle(10000, VehicleType.Car,"DL201D12",500, Status.Available,"swift desire");
        Vehicle v2 = new Vehicle(10000, VehicleType.Car,"DL201D13",500, Status.Available,"verna");
        Vehicle v3 = new Vehicle(10000, VehicleType.Car,"DL201D14",500, Status.Available,"swift desire");
        Vehicle v4 = new Vehicle(10000, VehicleType.Car,"DL201D15",500, Status.Available,"honda city");

        Store s1= new Store(l1);
        s1.addVehicle(v1);
        Store s2= new Store(l2);
        s2.addVehicle(v2);
        Store s3= new Store(l2);
        s3.addVehicle(v3);
        s3.addVehicle(v4);

        storelist.add(s1);
        storelist.add(s2);
        storelist.add(s3);

    }

    public void Greetings(){
        System.out.println("please put userId to login");
        int userId=scanner.nextInt();
        currentUser= userList.stream().filter((User u)->u.userId==userId).findFirst().get();

        System.out.println("hi there, how can i help you today");
        System.out.println("put the city want to search the vehicle for");
        String city= scanner.next();

        List<Store> relevantStores=storelist.stream().filter((Store s)->s.location.city.equals(city)).collect(Collectors.toList());
        relevantStores.stream().flatMap((Store s)->s.vehicleList.stream()).filter((Vehicle v)->v.status==Status.Available).forEach((Vehicle v)-> System.out.println(v.model+" "+v.numberPlate));

        System.out.println("choose vehicle by inputting vehicle number");
        String vehicleNumber = scanner.next();
        Vehicle chosedVehicle = relevantStores.stream().flatMap((Store s)->s.vehicleList.stream()).filter((Vehicle v)->v.numberPlate.equals(vehicleNumber)).findFirst().get();
        Store chosedStore = relevantStores.stream().filter((Store s)->s.vehicleList.contains(chosedVehicle)).findFirst().get();
        System.out.println(chosedVehicle);


        Location pickupLocation;
        Location dropOffLocation;
        LocalDateTime pickupDateTime;
        LocalDateTime dropOffDateTime;

        System.out.println("Now please choose pickup location");
        pickupLocation=inputLocation();
        System.out.println("Now please choose dropoff location");
        dropOffLocation=inputLocation();

        System.out.println("input the vehicle pickup time dd-MM-yyyy");
        String pickupDateTimeStr=scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        pickupDateTime = LocalDateTime.parse(pickupDateTimeStr,formatter);

        System.out.println("input the vehicle dropOff time dd-MM-yyyy");
        String dropOffDateTimeStr = scanner.nextLine();
        dropOffDateTime=LocalDateTime.parse(dropOffDateTimeStr,formatter);

        ticket=new BookingTicket(pickupLocation,dropOffLocation,pickupDateTime,dropOffDateTime,chosedVehicle);
        ticket.processBooking(currentUser,chosedStore);

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
