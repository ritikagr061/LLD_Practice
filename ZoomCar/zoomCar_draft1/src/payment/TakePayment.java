package payment;

import enums.PaymentMethod;

import java.util.Scanner;

public class TakePayment implements Payment {
    private int amount;
    public PaymentMethod paymentMethod;
    public PaymentPortalStrategy paymentPortalStrategy;

    public TakePayment(int amt) {
        amount=amt;
        System.out.println("Please select the payment method, type 1.debit or 2.upi");
        Scanner sc= new Scanner(System.in);
        String paymentType = sc.next();
        if(paymentType.equals("debit"))
            paymentMethod=PaymentMethod.debitCard;
        else if(paymentType.equals("upi"))
            paymentMethod=PaymentMethod.upi;
    }

    public boolean makePayment(){
        if(paymentMethod==PaymentMethod.upi)
            paymentPortalStrategy=new UpiPaymentPortalStrategy();
        else if(paymentMethod==PaymentMethod.debitCard)
            paymentPortalStrategy=new CardPaymentPortalStrategy();

        boolean isAuthenticated= paymentPortalStrategy.Authentication();
        if(isAuthenticated) {
            paymentPortalStrategy.makePayment(amount);
            return true;
        }
        else{
            System.out.println("Payment failed");
            return false;
        }
    }
}
