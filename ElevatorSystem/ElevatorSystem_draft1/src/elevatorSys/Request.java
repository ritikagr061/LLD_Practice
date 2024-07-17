package elevatorSys;

import entities.Direction;

public class Request {
    public int floor;
    public Direction direction; //"U" , "D"
    Request(int floor,Direction d){
        this.floor=floor;
        this.direction = d;
    }
}
