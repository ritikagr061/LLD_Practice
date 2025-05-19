package vendingMachineStates;

import entities.VendingMachine;

public interface State {
    //vending machine
    //1. user comes selects product by entering code, he can submit or cancel to return to idle state
    //2. after product selection, user puts in money , submits or cancels ( goes back to product selection state)
    //3. vending machine processes the money, goes to product refundAllMoney state(if money is not sufficient) or it goes to next step of refundExtraMoney
    //4. in refundAllMoney state simply money is returned and it simply goes back to product selection state
    //5. in refundExtraMoney state it simply returns extra money and goes to deliverProductState
    //6. in deliver product state we simply deliver the product.

    public void selectProduct(VendingMachine v);

    public void submit(VendingMachine v);
    public void cancel(VendingMachine v);

    public void insertMoney(VendingMachine v);

    public void refundMoney(VendingMachine v);

    public void deliverProduct(VendingMachine v);

}
