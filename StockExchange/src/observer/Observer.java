package observer;

import entities.Order;

public interface Observer {
    public void notify(Order user);
}
