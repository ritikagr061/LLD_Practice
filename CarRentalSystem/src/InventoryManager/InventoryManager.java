package InventoryManager;

import entities.Car;
import entities.CarStatus;
import entities.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<Car> cars;
    public static class Holder{
        private static final InventoryManager instance = new InventoryManager();
    }
    public static InventoryManager getInstance(){
        return Holder.instance;
    }
    private InventoryManager(){
        cars = new ArrayList<>();
        cars.add(new Car("Swift Desire",
                "UP14EE2924",
                new Location("Delhi",67883,"Rajiv Chowk"),
                CarStatus.AVAILABLE,
                100,
                new ArrayList<>(List.of(new Location("Delhi",67883,"Rajiv Chowk"))),
                new ArrayList<>(List.of(new Location("Delhi",67883,"Rajiv Chowk")))
                ));

        cars.add(new Car("Swift Desire",
                "UP14EE2925",
                new Location("Ghaziabad",202010,"Vaishali Sec 6"),
                CarStatus.AVAILABLE,
                100,
                new ArrayList<>(List.of(new Location("Ghaziabad",202010,"Vaishali Sec 6"))),
                new ArrayList<>(List.of(new Location("Ghaziabad",202010,"Vaishali Sec 6")))
        ));

        cars.add(new Car("Swift Desire",
                "UP14EE2926",
                new Location("Delhi",67883,"Rajiv Chowk"),
                CarStatus.AVAILABLE,
                100,
                new ArrayList<>(List.of(new Location("Delhi",67883,"Rajiv Chowk"))),
                new ArrayList<>(List.of(new Location("Delhi",67883,"Rajiv Chowk")))
        ));

        cars.add(new Car("Swift Desire",
                "UP14EE2927",
                new Location("Bangalore",33254,"xyz"),
                CarStatus.AVAILABLE,
                100,
                new ArrayList<>(List.of(new Location("Ghaziabad",202010,"Vaishali Sec 6"))),
                new ArrayList<>(List.of(new Location("Ghaziabad",202010,"Vaishali Sec 6")))
        ));
    }

    //add car
    //search available cars in city
    public void addCar(Car car){
        cars.add(car);
    }
    public List<Car> searchCityCars(String city){
        return cars.stream()
                .filter(c -> c.getStatus() == CarStatus.AVAILABLE)
                .filter(c -> c.getLocation().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
