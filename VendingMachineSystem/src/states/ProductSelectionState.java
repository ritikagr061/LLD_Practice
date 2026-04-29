package states;

import entities.Product;
import entities.VendingMachine;

import java.util.Scanner;

public class ProductSelectionState implements VendingMachineState{
    @Override
    public void printProducts(VendingMachine machine) {
        System.out.println("Invalid state");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("Available products are:");
        System.out.println(machine.getProducts().stream().map(p->p.getName()).toList());
        System.out.println("kindly type the product name to select");
        Scanner sc = new Scanner(System.in);
        String product = sc.next();
        Product selected = null;
        Product searchedProduct = machine.getProducts().stream().filter(p->p.getName().equals(product)).findFirst().orElse(null);
        if(searchedProduct!=null&&searchedProduct.getQuantity()>0){
            selected = searchedProduct;
            machine.setSelectedProduct(selected);
            machine.setVendingMachineState(new PaymentState());
            machine.getVendingMachineState().pay(machine);
        }
        else{
            System.out.println("Invalid/Unavailable product, canceling operation");
            cancelOperation(machine);
        }
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
        machine.setVendingMachineState(new Idle());
        machine.getVendingMachineState().printProducts(machine);
    }
}
