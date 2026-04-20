package entities;

import strategies.FifoStrategy;
import strategies.MovingStrategy;

public class ElevatorManager {
    private MovingStrategy elevatorMovingStrategy;
    private Elevator elevator;
    public ElevatorManager(){
        elevator = new Elevator();
        elevatorMovingStrategy = new FifoStrategy(elevator);
    }

    public void move(){
        elevatorMovingStrategy.move();
    }

    public MovingStrategy getElevatorMovingStrategy() {
        return elevatorMovingStrategy;
    }

    public void setElevatorMovingStrategy(MovingStrategy elevatorMovingStrategy) {
        this.elevatorMovingStrategy = elevatorMovingStrategy;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
}
