package vendingMachineStates;

import entities.VendingMachine;

public class DeliverProductState implements State{
    @Override
    public void selectProduct(VendingMachine v) {

    }

    @Override
    public void submit(VendingMachine v) {

    }

    @Override
    public void cancel(VendingMachine v) {

    }

    @Override
    public void insertMoney(VendingMachine v) {

    }

    @Override
    public void refundMoney(VendingMachine v) {

    }

    @Override
    public void deliverProduct(VendingMachine v) {
        System.out.println("Collect your product from the collection Tray");
        v.vendingMachineState=new IdleState();
        v.vendingMachineState.selectProduct(v);
    }
}
