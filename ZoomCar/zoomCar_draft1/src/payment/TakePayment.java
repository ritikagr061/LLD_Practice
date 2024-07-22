package payment;

import enums.PaymentMethod;

public class TakePayment extends Payment {
    public PaymentMethod paymentMethod;
    public PaymentPortalStrategy paymentPortalStrategy;

    public TakePayment(int amt) {
        super(amt);
    }

    public void makePayment(){
        if(paymentMethod==PaymentMethod.upi)
            paymentPortalStrategy=new UpiPaymentPortalStrategy();
        else if(paymentMethod==PaymentMethod.debitCard)
            paymentPortalStrategy=new DebitCardPaymentPortalStrategy();

        paymentPortalStrategy.makePayment(amount);
    }
}
