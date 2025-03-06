package observable;

import observer.ProductBackInInventoryObserver;

import java.util.List;

public class ProductBackInInventory implements EntityBackInInventory {
    List<ProductBackInInventoryObserver> observers;
    String name;
    int price;
    int stockAmt;

    public ProductBackInInventory( String name, int price, int stockAmt) {
        this.name = name;
        this.price = price;
        this.stockAmt = stockAmt;
    }

    @Override
    public void add(ProductBackInInventoryObserver obj) {
        observers.add(obj);
    }
    @Override
    public void remove(ProductBackInInventoryObserver obj) {
        observers.remove(obj);
    }
    @Override
    public void notifyAlert() {
        for(int i=0;i<observers.size();i++){
            ProductBackInInventoryObserver obj = observers.get(i);
            //now the most important question is how would observer know which observable class object
            // ( particular product in simple words ) inventory got filled again ?
            // 1). one way would be to pass each and every info obj.update(name,price,stockAmt);
            //  this is really a bad way of doing it since you are tying this class ( productBackInInventory ) to the class Email or AppNotify Observer
            // 2) make an interface based object inside the observers class and do dependency injection in constructor; -> which also ties a particular observer to particular product;
            // so obj.update();
            obj.update();
        }
    }
    @Override
    public void addStock(int stockSize) {
        if(this.stockAmt==0){
            notifyAlert();
        }
        this.stockAmt+=stockSize;
    }
    @Override
    public void reduceStock(int stockSize) {
        if(stockSize<=this.stockAmt)
            stockAmt-=stockSize;
    }

    public String getName(){
        return name;
    }
}
