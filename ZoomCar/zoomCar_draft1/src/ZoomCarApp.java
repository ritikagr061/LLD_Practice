import entitites.Location;
import entitites.Store;
import entitites.User;
import entitites.Vehicle;
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

    public String VehicleModel;
    public LocalDateTime pickupDateTime;
    public LocalDateTime dropOffDateTime;
    public int pickupLocationPinCode;
    public int dropOffLocationPinCode;
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

        System.out.println(chosedVehicle);

        System.out.println("Now please choose pickup location");


        System.out.println("Now please choose dropoff location");

    }
    public void takeInput(){
        System.out.println("input the vehicle model");
        VehicleModel = scanner.nextLine();
        System.out.println("input the vehicle pickup location pincode");
        pickupLocationPinCode= scanner.nextInt();
        System.out.println("input the vehicle dropoff location pincode");
        dropOffLocationPinCode=scanner.nextInt();


        System.out.println("input the vehicle pickup time");
        String pickupDateTimeStr=scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        pickupDateTime = LocalDateTime.parse(pickupDateTimeStr,formatter);

        System.out.println("input the vehicle dropOff time");
        String dropOffDateTimeStr = scanner.nextLine();
        dropOffDateTime=LocalDateTime.parse(dropOffDateTimeStr,formatter);

    }

}
