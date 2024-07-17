package Strategies;

import elevatorSys.Request;
import entities.Elevator;
import entities.ElevatorDoor;

import java.util.List;

public interface AssignElevatorStrategy {
    public Elevator assignElevator(List<Elevator> allElevators, Request request);
}
