package strategies;

import entities.Direction;
import entities.Elevator;
import entities.Request;

import java.util.Scanner;

public class FifoStrategy implements MovingStrategy{
    private Elevator elevator;
    public FifoStrategy(Elevator ele){
        elevator=ele;
    }

    @Override
    public void serveRequest() {
        //pop element //reach that floor //open door //close door // take input from user // reach that floor
        Request req = elevator.getRequestQueue().poll();
        elevator.setDirection(req.getFloor()>elevator.getCurrentFloor()? Direction.up:Direction.down);
        elevator.setCurrentFloor(req.getFloor());
        System.out.println("Reached floor "+req.getFloor()+ " door opens and closes");

        System.out.println("Press Floor you'd want to go to");
        Scanner sc = new Scanner(System.in);
        int destFloor = sc.nextInt();

        elevator.setDirection(destFloor>elevator.getCurrentFloor()? Direction.up:Direction.down);
        elevator.setCurrentFloor(destFloor);
        System.out.println("Reached destination floor "+destFloor + " door opens and closes" );
    }

    @Override
    public void move() {
        while(!elevator.getRequestQueue().isEmpty()){
            serveRequest();
        }
    }
}
