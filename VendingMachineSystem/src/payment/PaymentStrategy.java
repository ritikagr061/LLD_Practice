package payment;

import entities.Product;

public interface PaymentStrategy {
    public boolean pay(Product product);
}
