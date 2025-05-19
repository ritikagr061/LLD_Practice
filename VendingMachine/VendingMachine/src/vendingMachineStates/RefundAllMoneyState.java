package vendingMachineStates;

import entities.VendingMachine;

public class RefundAllMoneyState implements State {
    @Override
    public void selectProduct(VendingMachine v) {
        System.out.println("invalid operation on RefundAllMoney");
    }

    @Override
    public void submit(VendingMachine v) {
        System.out.println("invalid operation on RefundAllMoney");
    }

    @Override
    public void cancel(VendingMachine v) {
        System.out.println("invalid operation on RefundAllMoney");
    }

    @Override
    public void insertMoney(VendingMachine v) {
        System.out.println("invalid operation on RefundAllMoney");
    }

    @Override
    public void refundMoney(VendingMachine v) {
        System.out.println("Refunding Rs."+v.moneyReceived);
        v.moneyReceived=0;
        v.vendingMachineState=new IdleState();
        v.vendingMachineState.selectProduct(v);
    }

    @Override
    public void deliverProduct(VendingMachine v) {
        System.out.println("invalid operation on RefundAllMoney");
    }
}
