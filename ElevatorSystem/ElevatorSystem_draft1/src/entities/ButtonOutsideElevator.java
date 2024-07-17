package entities;

abstract public class ButtonOutsideElevator {
    public int floor;
    public boolean isPressed;
    abstract public void press(int x);
}
