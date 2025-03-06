import observable.ProductBackInInventory;
import observer.AppNotifyObservers;
import observer.EmailNotifyObservers;

public class Main {
    public static void main(String[] args) {
        //Question :

        //Let's say there could be multiple requirements of Notify feature , let product back in inventory
        //is one of them . So that's why made an interface of EntityBackInInventory so its implementation
        //class could be productBackInInventory or SellerBackInInventory and so on.

        //let's make few products
        ProductBackInInventory iphone = new ProductBackInInventory("iphone-15",200000,100);
        ProductBackInInventory television =  new ProductBackInInventory("LG-100inchTV",100000,80);
        ProductBackInInventory laptop = new ProductBackInInventory("macbook air pro",150000,40);

        //let's make few app observers
        AppNotifyObservers device1 = new AppNotifyObservers("samsungS24-94222",iphone);
        iphone.add(device1);
        AppNotifyObservers device2 = new AppNotifyObservers("oppoA52-19973",television);
        television.add(device2);

        //let's make few email observers
        EmailNotifyObservers email1 = new EmailNotifyObservers("ritikagr01@gmail.com",iphone);
        iphone.add(email1);
        EmailNotifyObservers email2 = new EmailNotifyObservers("ritik.agrawal@newgensoft.com",laptop);
        laptop.add(email2);
        
        //now lets make laptop's inventory empty
        iphone.reduceStock(100);
        //now lets add stock
        iphone.addStock(10);
        //this should trigger the message in console for both the observers email1 and device1.
    }
}