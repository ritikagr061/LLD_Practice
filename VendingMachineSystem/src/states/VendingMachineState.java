package states;

import entities.VendingMachine;

public interface VendingMachineState {
    public void printProducts(VendingMachine machine);
    public void selectProduct(VendingMachine machine);
    public void pay(VendingMachine machine);
    public void dispense(VendingMachine machine);
    public void cancelOperation(VendingMachine machine);
}
