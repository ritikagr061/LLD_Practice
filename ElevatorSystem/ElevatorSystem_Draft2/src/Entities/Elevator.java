package Entities;

import Enums.Direction;

import java.util.*;

public class Elevator {
    Scanner sc= new Scanner(System.in);
    public int maxFloor;
    public Set<Integer> requestedFloor=new TreeSet<>();
    public Set<Integer> callingRequestsUp = new TreeSet<>();
    public Set<Integer> callingRequestDown = new TreeSet<>();
    public int currentFloor;
    public Direction direction;
    public int weightCapacity;
    public Door door;
    public List<ElevatorCallingButton> callingButtons;

    public Elevator(int x,int currentFloor,Direction d){
        maxFloor=x;
        this.currentFloor=currentFloor;
        this.direction=d;
        this.weightCapacity=1000;
        door=new Door();
        callingButtons=new ArrayList<>();
        for(int i=0;i<=x;i++){
            callingButtons.add(new ElevatorCallingButton(i+1));
        }
    }

    public void readCallingRequests(){
        Scanner sc=new Scanner(System.in);
        System.out.println("do you want to call the elevator at your floor Y/N ?");
        String input=sc.next();
        if(input.equals("Y")){
            System.out.println("Please enter you current floor");
            int floor=sc.nextInt();
            System.out.println("Please choose the direction in which you want to go U/D ?");
            String upOrDown=sc.next();
            if(upOrDown.equals("U")){
                callingButtons.get(floor).pressUpButton();
                this.addUpRequest(floor);
            }
            else{
                callingButtons.get(floor).pressDownButton();
                this.addDownRequest(floor);
            }

        }
        else{
            System.out.println("okay!");
        }
    }
    public boolean shouldChangeDirection(){
        if(direction==Direction.up&&currentFloor==maxFloor)
            return true;
        if(direction==Direction.down&&currentFloor==0)
            return true;

        if(direction==Direction.up){
            boolean hasCalling=callingRequestsUp.stream().filter((Integer i)->i>currentFloor).findAny().isPresent()||callingRequestDown.stream().filter((Integer i)->i>currentFloor).findAny().isPresent();
            boolean hasDestination=requestedFloor.stream().filter((Integer i)->i>currentFloor).findAny().isPresent(); //destination floors
            if(hasCalling||hasDestination)
                return false;
            else return true;
        }
        else{
            boolean hasCalling=callingRequestsUp.stream().filter((Integer i)->i<currentFloor).findAny().isPresent()||callingRequestDown.stream().filter((Integer i)->i<currentFloor).findAny().isPresent();
            boolean hasDestination=requestedFloor.stream().filter((Integer i)->i<currentFloor).findAny().isPresent(); //destination floors
            if(hasCalling||hasDestination)
                return false;
            else return true;
        }
    }

    public void changeDirection(){
        if(direction==Direction.up) {
            direction = Direction.down;
            System.out.println("lift is moving down now");
        }
        else {
            direction=Direction.up;
            System.out.println("lift is moving up now");
        }

    }

    public void openDoor(){
        door.openDoor(currentFloor);
        System.out.println("please input the destination floor you want to reach");
        int dest=sc.nextInt();
        requestedFloor.add(dest);
        door.closeDoor();
    }

    //moves in the same direction as previous
    //decides if door should open, if opens then takes user input for destination floor
    public void moveElevator(){
        if(direction==Direction.up){
            currentFloor++;
            if(callingRequestsUp.contains(currentFloor)||requestedFloor.contains(currentFloor)){
                openDoor();
                callingButtons.get(currentFloor).unPressUpButton();
            }
            else System.out.println("door not opened at floor "+currentFloor);
        }
        else{
            currentFloor--;
            if(callingRequestDown.contains(currentFloor)||requestedFloor.contains(currentFloor))
            {
                openDoor();
                callingButtons.get(currentFloor).unPressDownButton();
            }
            else System.out.println("door not opened at floor "+currentFloor);
        }

    }

    public boolean shouldLiftStop(){
        if(requestedFloor.isEmpty() && callingRequestsUp.isEmpty() && callingRequestDown.isEmpty())
            return true;
        else return false;
    }

    public void addUpRequest(int floor) {
        callingRequestsUp.add(floor);
    }

    public void addDownRequest(int floor) {
        callingRequestDown.add(floor);
    }
}
