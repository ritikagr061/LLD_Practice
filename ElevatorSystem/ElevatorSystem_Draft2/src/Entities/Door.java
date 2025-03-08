package Entities;

import Enums.OpenStatus;

public class Door {
    OpenStatus openStatus;
    public Door(){
        openStatus=OpenStatus.close;
    }
    public void openDoor(int floor){
        openStatus=OpenStatus.open;
        System.out.println("elevator door opened at floor "+floor);
    }
    public void closeDoor(){
        openStatus=OpenStatus.close;
        System.out.println("elevator door closed");
    }
}
