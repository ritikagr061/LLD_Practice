package payment;

import entities.DenominationHandler;
import entities.Product;

import java.util.List;
import java.util.Scanner;

public class CashPayment implements PaymentStrategy{
    private DenominationHandler handler;

    public CashPayment(DenominationHandler handler) {
        this.handler = handler;
    }

    public DenominationHandler getHandler() {
        return handler;
    }

    public void setHandler(DenominationHandler handler) {
        this.handler = handler;
    }

    @Override
    public boolean pay(Product product) {
        int prodPrice = product.getPrice();
        System.out.println("Please enter the cash notes as comma seperated integers");
        Scanner sc= new Scanner(System.in);
        String cashString= sc.next();
        List<Integer> notesToBeReturned = handler.isTransactionPossible(cashString,prodPrice);
        if(notesToBeReturned==null)
            return false;
        else{
            handler.completePayment(cashString,notesToBeReturned);
            return true;
        }
    }
}
