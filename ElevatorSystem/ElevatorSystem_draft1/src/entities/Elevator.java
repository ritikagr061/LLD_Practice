package entities;

import elevatorSys.Request;

import java.util.*;

public class Elevator {
    public int Id;
    public Display display;
    public ElevatorDoor door;
    public List<ButtonsInsideElevator> buttons;
    public Queue<Integer> whileUp; // request from inside as well as outside
    public Queue<Integer> whileDown; //requests from inside as well as outside

    public Elevator(int id){
        this.Id=id;
        display=new Display(Direction.Idle,0);
        buttons = new ArrayList<>();
        for(int i=0;i<= Building.totalFloors;i++){
            buttons.add(new ButtonsInsideElevator(i));
        }
        whileUp = new PriorityQueue<>();
        whileDown= new PriorityQueue<>(Collections.reverseOrder());
        door = new ElevatorDoor();
    }

    public void press(int button){
        buttons.get(button).isPressed=true;
        if(button<display.currentFloor){
            whileDown.add(button);
        }
        else if(button>display.currentFloor)
            whileUp.add(button);
        else{
            System.out.println("please step outside the elevator, you are already at you destination");
        }
    }

    public void openDoor(){
        door.isOpen=true;
        System.out.println("elevator "+Id+" door at "+ display.currentFloor +" floor is open now");
        // input all the floors it wants to go
        System.out.println("input all the request floors as integers in a single line");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] inputs=line.split(" ");
        for(String str:inputs){
            if(Integer.parseInt(str)<display.currentFloor){
                whileDown.add(Integer.parseInt(str));
            }
            else if(Integer.parseInt(str)>display.currentFloor){
                whileUp.add(Integer.parseInt(str));
            }
        }
        closeDoor();
    }
    public void closeDoor(){
        door.isOpen=false;
        System.out.println("elevator "+Id+" door at "+ display.currentFloor +" floor is closed now");
    }

    public void addRequestWhileUp(Request req){
        whileUp.add(req.floor);
    }
    public void addRequestWhileDown(Request req){
        whileDown.add(req.floor);
    }

    public void start(){
        if(display.direction==Direction.Down) {
            handleDown();
        }
        if(display.direction==Direction.Up){
            handleUp();
        }
    }

    public void handleUp(){
        while(!whileUp.isEmpty()){
            int x=whileUp.poll();
            display.currentFloor=x;
            openDoor();
        }
        if(whileDown.isEmpty()){
            display.direction = Direction.Idle;
            System.out.println("the elevator "+ Id + " has become idle now");
        }
        else{
            display.direction = Direction.Down;
            handleDown();
        }

    }

    public void handleDown(){
        while(!whileDown.isEmpty()){
            int x=whileDown.poll();
            display.currentFloor=x;
            openDoor();
        }
        if (whileUp.isEmpty()){
            display.direction = Direction.Idle;
            System.out.println("the elevator "+ Id + " has become idle now");
        }
        else{
            display.direction = Direction.Up;
            handleUp();
        }

    }

}
