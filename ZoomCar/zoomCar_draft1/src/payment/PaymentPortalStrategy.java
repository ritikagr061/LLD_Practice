package payment;

public interface PaymentPortalStrategy {
    public boolean Authentication();
    public void makePayment(int amount);
}
