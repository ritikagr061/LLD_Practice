import entitites.Store;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ZoomCarApp {

    public static List<Store> storelist;
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

    public void Greetings(){
        System.out.println("hi there, how can i help you today");
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

        optimalStore = checkVehicle();
        if(optimalStore==null){
            System.out.println("vehicle couldn't be found sorry, change your search");
            return;
        }
        else{

        }
    }

    public Store checkVehicle(){

        return null;
    }


}
