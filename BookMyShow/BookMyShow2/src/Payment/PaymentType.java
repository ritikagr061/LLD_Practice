package Payment;

public interface PaymentType {
    public boolean authenticate();
    public boolean doPayment(int amnt);
}
