package Strategies;

import elevatorSys.Request;
import entities.Building;
import entities.Direction;
import entities.Elevator;

import java.util.List;

public class defaultAssignElevatorStrategy implements AssignElevatorStrategy{
    @Override
    public Elevator assignElevator(List<Elevator> allElevators, Request request) {

        //  3 scenarios of lift could service the request if
        // i) a lift is idle and is closest to request floor compared to other lifts
        // ii) or if lift is travelling in same direction plus that lift should be about to reach request floor
        // iii) or if lift is travelling in opposite direction then we could add the request in its return journey
        Elevator ans=null;
        int closest= 2*Building.totalFloors;
        for(Elevator ele: allElevators){
            if(ele.display.direction== Direction.Idle){
                if(Math.abs(ele.display.currentFloor- request.floor)<closest){
                    ans=ele;
                    closest=Math.abs(ele.display.currentFloor- request.floor);
                }
            }else if(ele.display.direction==request.direction){
                if((ele.display.direction==Direction.Up&&request.floor>ele.display.currentFloor)||
                        (ele.display.direction==Direction.Down&&request.floor<ele.display.currentFloor)){
                    if(Math.abs(ele.display.currentFloor - request.floor)<closest){
                        ans=ele;
                        closest=Math.abs(ele.display.currentFloor- request.floor);
                    }
                }
            }
            else{
                //irrespective of distance lift has to travel I am simply just assigning in the else case
                if(closest==2*Building.totalFloors){
                    ans=ele;
                }
            }
        }
        return ans;
    }

}
