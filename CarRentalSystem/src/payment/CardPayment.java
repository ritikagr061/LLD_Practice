package payment;

public class CardPayment implements PaymentService{
    @Override
    public boolean pay(long amount) {
        System.out.println("Card payment successful for $" + amount);
        return true;
    }
}
