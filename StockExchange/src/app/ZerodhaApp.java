package app;

import entities.Order;
import observer.OrderExecutor;
import observer.TradeRepository;
import observer.UserManager;

public class ZerodhaApp {
    private OrderExecutor orderExecutor;
    private UserManager userManager;
    private TradeRepository tradeRepository;
    public ZerodhaApp(){
        orderExecutor = OrderExecutor.getInstance();
        userManager = UserManager.getInstance();
        tradeRepository = TradeRepository.getInstance();
    }

    public void createOrder(Order order){
        orderExecutor.addOrder(order);
    }

    public void executeOrders(){
        orderExecutor.executeOrders();
    }
}
