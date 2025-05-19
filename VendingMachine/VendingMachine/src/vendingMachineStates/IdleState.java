package vendingMachineStates;

import entities.Product;
import entities.VendingMachine;

import java.util.Scanner;

public class IdleState implements State {
    public IdleState(){
        //product=p;
    }
    @Override
    public void selectProduct(VendingMachine v) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please select the prouduct from list of Products, by entering the product code");
        String code=sc.next();
        v.selectedProduct=VendingMachine.availableProd.stream().filter((Product p)->p.code.equals(code)).findFirst().get();
        System.out.println("Do you want to move to payments Y/N?");
        String ans=sc.next();
        if(ans.equals("Y")){
            submit(v);
        }
        else{
            cancel(v);
        }
    }

    @Override
    public void submit(VendingMachine v) {
        v.vendingMachineState=new AcceptMoneyState();
        v.vendingMachineState.insertMoney(v);
    }

    @Override
    public void cancel(VendingMachine v) {
        System.out.println("Returning back!");
        v=new VendingMachine(); //for resetting...
    }

    @Override
    public void insertMoney(VendingMachine v) {

    }

    @Override
    public void refundMoney(VendingMachine v) {

    }

    @Override
    public void deliverProduct(VendingMachine v) {

    }

}
