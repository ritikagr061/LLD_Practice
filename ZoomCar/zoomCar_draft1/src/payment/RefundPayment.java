package payment;

public class RefundPayment implements Payment{
    private int amount;
    //used when  returning security deposit.
    public RefundPayment(int amt) {
        amount=amt;
    }

    @Override
    public boolean makePayment() {

        return true;
    }
}
