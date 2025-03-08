import Entities.Elevator;
import Entities.ElevatorCallingButton;
import Enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorManager {
    Elevator elevator;
    int maxFloor;


    public ElevatorManager(int x){
        maxFloor=x;

        elevator=new Elevator(maxFloor,0, Direction.up);
    }



    public void StartElevatorOperation(){
        while(true){
            elevator.readCallingRequests();
            if(!elevator.shouldLiftStop())
                elevator.moveElevator(); //checks if it needs to stop after moving to specific floor
                //also opens door if required and takes input from newly entered user.
            if(elevator.shouldChangeDirection())
                elevator.changeDirection();
        }
    }
}
