package elevatorSys;

import Strategies.AssignElevatorStrategy;
import Strategies.defaultAssignElevatorStrategy;
import entities.Building;
import entities.Direction;
import entities.Elevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevatorManager {
    public List<Request> toAssign;
    public List<Elevator> elevators;
    public AssignElevatorStrategy assigningStrategy;

    public ElevatorManager(){
        toAssign=new ArrayList<>();
        elevators=new ArrayList<>();
        for(int i=1;i<= Building.totalElevators;i++){
            elevators.add(new Elevator(i));
        }
        assigningStrategy = new defaultAssignElevatorStrategy();
    }

    public void makeRequests(Request... requests){
        toAssign.addAll(Arrays.asList(requests));
        processRequests();
    }
    public void processRequests(){
        for(Request req: toAssign){
            Elevator bestElevator=assigningStrategy.assignElevator(elevators,req);
            if(bestElevator.display.direction==Direction.Idle){
                bestElevator.display.direction=req.floor<bestElevator.display.currentFloor?Direction.Down:Direction.Up;
            }//now every idle elevator has a direction, based on this direction we are going to serve other requests coming to this elevator
            if(req.direction== Direction.Down){
                bestElevator.addRequestWhileDown(req);
            }
            else{
                bestElevator.addRequestWhileUp(req);
            }
        }

        for(Elevator ele:elevators){
            System.out.println("********* elevator "+ele.Id+" starts ***********");

        }
    }

}
