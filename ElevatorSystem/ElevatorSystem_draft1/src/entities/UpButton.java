package entities;

public class UpButton extends ButtonOutsideElevator{
    public UpButton(int floor) {
        this.floor=floor;
        this.isPressed=false;
    }

    public void press(int button){
        this.isPressed=true;
    }
}
