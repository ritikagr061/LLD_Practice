package entities;

public class ElevatorDoor {
    public boolean isOpen;
    ElevatorDoor(){
        this.isOpen=false;
    }
    public void open(){
        isOpen=true;
    }
}
