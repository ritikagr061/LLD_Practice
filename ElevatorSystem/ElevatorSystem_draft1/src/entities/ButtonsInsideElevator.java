package entities;

public class ButtonsInsideElevator {
    public int floor;
    public boolean isPressed;

    public ButtonsInsideElevator(int floor) {
        this.floor = floor;
        this.isPressed = false;
    }

    public void press(){
        isPressed=true;
    }
    public void unPress(){
        isPressed=false;
    }
}
