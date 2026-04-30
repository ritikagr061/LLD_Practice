package payment;

public class CashPayment implements PaymentService{
    @Override
    public boolean pay(long amount) {
        System.out.println("Cash payment successful for $" + amount);
        return true;
    }
}
