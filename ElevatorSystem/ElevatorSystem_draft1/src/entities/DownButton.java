package entities;

public class DownButton extends ButtonOutsideElevator{
    public DownButton(int floor) {
        this.floor=floor;
        this.isPressed=false;
    }

    public void press(int button){
        this.isPressed=true;
    }
}
