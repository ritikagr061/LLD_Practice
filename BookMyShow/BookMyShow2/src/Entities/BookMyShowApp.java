package Entities;

import Observers.TicketObserver;
import enums.Dimension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookMyShowApp implements TicketObserver {
    private static BookMyShowApp instance=null;
    private List<Hall> halls;
    private List<User> users;
    private List<Ticket> tickets;
    private User currentUser;
    private Scanner sc=new Scanner(System.in);
    public static BookMyShowApp getInstance(){
        if(instance==null)
        {
            instance=new BookMyShowApp();
        }
        return instance;
    }
    private int movieIdCount=1;

    private BookMyShowApp(){
        //intializing halls and users by ourselefs
        //todo
        users=new ArrayList<>();
        users.add(new User(1,"Ritik"));
        users.add(new User(2,"Ankit"));
        tickets=new ArrayList<>();
        halls=new ArrayList<>();

        halls.add(createHall("Mission Impossible","Krish"));
        halls.add(createHall("Mission Impossible 2","Chaava"));


    }
    private Hall createHall(String m1,String m2){
        List<List<Seat>> arrangement=new ArrayList<>();
        for(int i=0;i<5;i++){
            List<Seat> temp=new ArrayList<>();
            for(int j=0;j<5;j++){
                Seat s=new Seat(i,j);
                temp.add(s);
            }
            arrangement.add(temp);
        }
        List<Movie> m=new ArrayList<>();
        LocalDateTime st = LocalDateTime.parse("10-03-2025 18:30", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        LocalDateTime en= LocalDateTime.parse("10-03-2025 20:30", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        m.add(new Movie(m1,movieIdCount,"hindi", Dimension.threeD, st,en,200));
        movieIdCount++;
        m.add(new Movie(m2,movieIdCount,"hindi", Dimension.threeD, st,en,300));
        movieIdCount++;

        return new Hall("Delhi","Vasant kunj",arrangement,m);
    }

    public void interactWithUser(){
        System.out.println("hey, login to your id,type userId to login");
        int userId=sc.nextInt();
        currentUser=users.stream().filter((User u)->u.userId==userId).findAny().get();

        System.out.println("type the city you want to search for");
        String searchCity=sc.next();
        List<Hall> relevantHalls = halls.stream().filter((Hall h)->h.city.equals(searchCity)).collect(Collectors.toList());
        relevantHalls.stream().flatMap((Hall h)->h.schedule.stream()).forEach((Movie m)-> System.out.println(m.movieId+" "+m.name+" "+m.language+" "+m.startTime+" "+m.endTime));
        System.out.println("select the movie by typing the movieId");
        int selectedId=sc.nextInt();
        Movie selectedMovie = relevantHalls.stream().flatMap((Hall h)->h.schedule.stream()).filter((Movie m)->m.movieId==selectedId).findAny().get();
        Hall selectedHall = relevantHalls.stream().filter((Hall h)-> h.schedule.contains(selectedMovie)).findAny().get();

        //selecte the seats and number of persons and change the status of those seats from empty to booked.

    }

    @Override
    public void informBooking(Ticket t) {
        tickets.add(t);
    }
}
