package observer;

import observable.ProductBackInInventory;

public class AppNotifyObservers implements ProductBackInInventoryObserver{
    public String deviceId;
    public ProductBackInInventory product;

    public AppNotifyObservers(String device,ProductBackInInventory prod){
        this.deviceId=device;
        this.product=prod;
    }
    @Override
    public void update() {
        System.out.println(product.getName()+" is available in inventory . Check it in your app before it's gone");
    }
}
