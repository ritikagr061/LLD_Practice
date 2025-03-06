package observable;

import observer.ProductBackInInventoryObserver;

public interface EntityBackInInventory {
    void add(ProductBackInInventoryObserver obj);

    public void remove(ProductBackInInventoryObserver obj);
    public void notifyAlert();

    public void addStock(int stockSize);
    public void reduceStock(int stockSize);

}
