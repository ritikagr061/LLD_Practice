package observer;

import observable.ProductBackInInventory;

public class EmailNotifyObservers implements ProductBackInInventoryObserver{
    public String emailId;
    public ProductBackInInventory product;

    public EmailNotifyObservers(String email,ProductBackInInventory prod){
        this.emailId=email;
        this.product=prod;
    }
    @Override
    public void update(){
        System.out.println(product.getName()+" is available again. Check it out before stock's gone");
    }
}
