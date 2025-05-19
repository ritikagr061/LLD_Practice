import entities.Product;
import entities.VendingMachine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //we have entities such as vendingMachine, Product , State
        //vending machine states
        //1. IdleState : user comes selects product by entering code, he can submit request(to move to PaymentState) or cancel request(to return to IdleState)
        //2. PaymentState: , user puts in money , submits(goes to either refundAllMoney or refundExtraMoney) or cancels ( goes to refundAllMoneyState )
        //3. vending machine processes the money, goes to product refundAllMoney state(if money is not sufficient) or it goes to next step of refundExtraMoney
        //4. refundAllMoney: state simply money is returned and it simply goes back to IdleState
        //5. refundExtraMoney: state it simply returns extra money and goes to deliverProductState
        //6. in deliver product state we simply deliver the product.
        VendingMachine.availableProd.addAll(Arrays.asList(
                new Product("101",20,"Coke"),
                new Product("102",30,"Kurkure"),
                new Product("103",20,"Pepsi")
        ));
        VendingMachine myMachine=new VendingMachine();

    }
}