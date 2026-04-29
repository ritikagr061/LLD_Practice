package states;

import entities.Product;
import entities.VendingMachine;

public class DispenseState implements VendingMachineState{
    @Override
    public void printProducts(VendingMachine machine) {
        System.out.println("Invalid state");
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
        System.out.println("Dispensing the product: "+machine.getSelectedProduct().toString());
        Product prod =machine.getProducts().stream().filter(p->machine.getSelectedProduct().getName().equals(p.getName())).findFirst().get();
        prod.setQuantity(prod.getQuantity()-1);
        machine.setVendingMachineState(new Idle());
        machine.getVendingMachineState().printProducts(machine);
    }

    @Override
    public void cancelOperation(VendingMachine machine) {
        System.out.println("Invalid state");
    }
}
