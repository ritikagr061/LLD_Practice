package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Theatre {
    public String city;
    public List<Hall> halls = new ArrayList<>();
    public ArrayList<ArrayList<Object>> schedules = new ArrayList<>();
    public Integer hallCount;

    public Theatre(){
        System.out.println("type city name ");
        Scanner scanner = new Scanner(System.in);
        this.city=scanner.nextLine();

        System.out.println("hall count ");
        this.hallCount = scanner.nextInt();

        for(int i=0;i<hallCount;i++){
            System.out.println("info for hall "+i);
            Hall temp= new Hall();
            halls.add(temp);
        }

        System.out.println("numb of scedules you wanna put ? ");
        int x = scanner.nextInt();

        for(int i=0;i<x;i++){
            System.out.println("input for schedule "+i);
            System.out.println("start hr");
            int st=scanner.nextInt();
            System.out.println("ending hr");
            int en= scanner.nextInt();
            System.out.println("movie name");
            String movie=scanner.nextLine();
            ArrayList<Object> temp=new ArrayList<>();
            temp.add(st);
            temp.add(en);
            temp.add(movie);

            schedules.add(temp);
        }
    }
}
