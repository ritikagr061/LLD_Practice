package payment;

import entities.Product;

public class UPIPayment implements PaymentStrategy{
    public UPIPayment() {
    }

    @Override
    public boolean pay(Product product) {
        System.out.println("Payment for "+product.getPrice()+" is completed successfully!");
        return true;
    }
}
