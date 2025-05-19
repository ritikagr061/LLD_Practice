package vendingMachineStates;

import entities.VendingMachine;

import java.util.Scanner;

public class AcceptMoneyState implements State{
    @Override
    public void selectProduct(VendingMachine v) {
        System.out.println("invalid operation on AcceptMoneyState");
    }

    @Override
    public void submit(VendingMachine v) {
        if(v.moneyReceived>v.selectedProduct.price){
            v.vendingMachineState=new RefundExtraMoneyState();
            v.vendingMachineState.refundMoney(v);
        }
        else if(v.moneyReceived<v.selectedProduct.price){
            v.vendingMachineState=new RefundAllMoneyState();
            v.vendingMachineState.refundMoney(v);
        }
        else{
            v.vendingMachineState=new DeliverProductState();
            v.vendingMachineState.deliverProduct(v);
        }
    }

    @Override
    public void cancel(VendingMachine v) {
        v.vendingMachineState=new RefundAllMoneyState();
        v.vendingMachineState.refundMoney(v);
    }

    @Override
    public void insertMoney(VendingMachine v) {
        Scanner sc=new Scanner(System.in);
        System.out.println("For the choosed product you need to pay Rs."+v.selectedProduct.price);
        System.out.println("Please put money into the collection box");
        v.moneyReceived=sc.nextInt();

        System.out.println("Do you want to continue further? or cancel? Y/N");
        String choice=sc.next();
        if(choice.equals("Y"))
            submit(v);
        else cancel(v);
    }

    @Override
    public void refundMoney(VendingMachine v) {
        System.out.println("invalid operation on AcceptMoneyState");
    }

    @Override
    public void deliverProduct(VendingMachine v) {
        System.out.println("invalid operation on AcceptMoneyState");
    }
}
