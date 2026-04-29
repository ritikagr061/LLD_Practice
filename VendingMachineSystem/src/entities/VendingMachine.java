package entities;

import payment.PaymentStrategy;
import states.Idle;
import states.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> products;
    private DenominationHandler denominationHandler;
    private PaymentStrategy paymentStrategy;
    private VendingMachineState vendingMachineState;
    private Product selectedProduct;

    public VendingMachine() {
        vendingMachineState = new Idle();
        products= new ArrayList<>();
        products.add(new Product("Kurkure",20,10));
        products.add(new Product("Fanta",20,10));
        products.add(new Product("Snickers",30,5));
        denominationHandler = new DenominationHandler();
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DenominationHandler getDenominationHandler() {
        return denominationHandler;
    }

    public void setDenominationHandler(DenominationHandler denominationHandler) {
        this.denominationHandler = denominationHandler;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
