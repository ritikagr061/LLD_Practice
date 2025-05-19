package entities;

import vendingMachineStates.IdleState;
import vendingMachineStates.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    public State vendingMachineState;
    public static List<Product> availableProd=new ArrayList<>();
    public Product selectedProduct;
    public Integer moneyReceived;

    public VendingMachine(){
        vendingMachineState=new IdleState();
        selectedProduct=null;
        moneyReceived=0;

        System.out.println("Wanna select a product? Y/N");
        Scanner sc=new Scanner(System.in);
        String choice=sc.next();
        if(choice.equals("Y"))
            vendingMachineState.selectProduct(this);
        
    }
}
