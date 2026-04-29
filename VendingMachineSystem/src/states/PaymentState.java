package states;

import entities.VendingMachine;
import payment.CashPayment;
import payment.UPIPayment;

import java.util.Scanner;

public class PaymentState implements VendingMachineState{
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
        System.out.println("Would you like to move ahead with payment Y/N?");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        boolean paymentDone = false;
        if(choice.equals("Y")){
            System.out.println("1. UPI or 2. cash ?");
            int paymentChoice = sc.nextInt();
            if(paymentChoice==1){
                machine.setPaymentStrategy(new UPIPayment());
                paymentDone = machine.getPaymentStrategy().pay(machine.getSelectedProduct());
            }
            else{
                machine.setPaymentStrategy(new CashPayment(machine.getDenominationHandler()));
                paymentDone = machine.getPaymentStrategy().pay(machine.getSelectedProduct());
            }
            if(paymentDone){
                machine.setVendingMachineState(new DispenseState());
                machine.getVendingMachineState().dispense(machine);
            }
            else{
                System.out.println("Payment Failed! canceling operation");
                cancelOperation(machine);
            }
            return;
        }
        else{
            System.out.println("Canceling operation");
            cancelOperation(machine);
            return;
        }

    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Invalid state");
    }

    @Override
    public void cancelOperation(VendingMachine machine){
        machine.setVendingMachineState(new Idle());
        machine.getVendingMachineState().printProducts(machine);
    }
}
