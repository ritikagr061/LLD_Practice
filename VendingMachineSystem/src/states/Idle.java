package states;

import entities.VendingMachine;

public class Idle implements VendingMachineState{
    @Override
    public void printProducts(VendingMachine machine) {
        System.out.println(machine.getProducts());
        machine.setVendingMachineState(new ProductSelectionState());
        machine.getVendingMachineState().selectProduct(machine);
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("Invalid state");
    }

    @Override
    public void pay(VendingMachine machine) {
        System.out.println("Invalid state");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Invalid state");
    }

    @Override
    public void cancelOperation(VendingMachine machine) {
        System.out.println("Invalid state");
    }
}
