package vendingMachineStates;

import entities.VendingMachine;

public class RefundExtraMoneyState implements State{
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
        System.out.println("Refunding Rs."+(v.moneyReceived-v.selectedProduct.price));
        v.moneyReceived=v.selectedProduct.price;
        v.vendingMachineState=new DeliverProductState();
        v.vendingMachineState.deliverProduct(v);
    }

    @Override
    public void deliverProduct(VendingMachine v) {

    }
}
