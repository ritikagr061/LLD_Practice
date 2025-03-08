package Entities;

public class ElevatorCallingButton {

    public int floor;
    public ElevatorCallingButton(int floor){
        this.floor=floor;
    }
    boolean upPressed=false;
    boolean downPressed=false;

    public void pressUpButton(){
        upPressed=true;
    }
    public void pressDownButton(){
        downPressed=true;
    }
    public void unPressUpButton(){
        upPressed=false;
    }
    public void unPressDownButton(){
        downPressed=false;
    }
}
