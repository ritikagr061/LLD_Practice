import entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMyShowApp {
    private List<Cinema> cinemaList;

    public BookMyShowApp() {
        cinemaList = new ArrayList<>();
    }

    public void initializeTestSystem(){
        Hall hall1 = new Hall(1, new ArrayList<>(List.of(new Seat(1, SeatLevel.tier1),new Seat(2,SeatLevel.tier2), new Seat(3,SeatLevel.tier3))));
        Hall hall2 = new Hall(2, new ArrayList<>(List.of(new Seat(1, SeatLevel.tier1),new Seat(2,SeatLevel.tier2), new Seat(3,SeatLevel.tier3))));

        Show show1 = new Show("Dhurandhar: The Revenge",
                1,
                LocalDateTime.of(2026,04,24,10,30),
                LocalDateTime.of(2026,04,24,14,30)
        );
        Show show2= new Show("Dhurandhar:1",
                2,
                LocalDateTime.of(2026,04,24,10,30),
                LocalDateTime.of(2026,04,24,14,30)
        );
        Cinema cinema = new Cinema(
                new ArrayList<>(List.of(hall1,hall2)), new ArrayList<>(List.of(show1,show2)), "Delhi");
        cinemaList.add(cinema);

    }

    public void searchShows(){
        System.out.println("Type the city");
        Scanner sc = new Scanner(System.in);
        String searchedCity = sc.next();
        System.out.println("Type the movie you want to watch");
        String movieName  = sc.next();

        List<Cinema> relevantCinemas = cinemaList.stream().filter((Cinema cinema) -> cinema.getCity().equals(searchedCity)).filter((Cinema cinema) -> cinema.getShows().getMovieName().equals(movieName)).findFirst();
    }
}
