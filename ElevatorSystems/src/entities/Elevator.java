package entities;

import strategies.MovingStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private Queue<Request> requestQueue;
    private List<Button> buttons;
    private State state;
    private Direction direction;
    private Integer currentFloor;
    private boolean isDoorOpen;

    public Elevator(){
        buttons = new ArrayList<>();
        buttons.addAll(List.of(new Button(1),new Button(2),new Button(3),
                new Button(4), new Button(5)));
        state = State.idle;
        direction = Direction.down;
        currentFloor = 1;
        isDoorOpen = false;
        //setting request queue
        requestQueue = new LinkedList();
        Queue<Request> requests = new LinkedList<>();
        requests.add(new Request(2,Direction.up));
        requests.add(new Request(5,Direction.down));
        setRequestQueue(requests);
    }

    public Queue<Request> getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(Queue<Request> requestQueue) {
        this.requestQueue = requestQueue;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }
}
