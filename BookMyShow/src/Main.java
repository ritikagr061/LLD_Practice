public class Main {
    //ticket - theatre, hallNumber , movie , timings

    //movie - name,language,type(3d/2d).

    //Theatre(multiplex or single screen) - Array<Hall> , city , Schedule<Object><Object> (object = dateTime / movie)
    //Schedule = table with 3 columns - start time , end time , movie.

    //Hall - hallNumber , rowCount , columnCount , Array<Seat><Seat> , currentMovie

    //Seat - price , isBooked

    //city , movie , date
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}