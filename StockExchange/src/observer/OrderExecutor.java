package observer;

import entities.Order;
import entities.OrderBook;
import entities.OrderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderExecutor {
    private List<Observer> observers;
    private Map<String, OrderBook> globalOrderList;

    public static class Holder{
        public static final OrderExecutor instance = new OrderExecutor();
    }
    public static OrderExecutor getInstance(){
        return Holder.instance;
    }
    private OrderExecutor(){
        observers = new ArrayList<>();
        observers.add(TradeRepository.getInstance());
        observers.add(UserManager.getInstance());
        globalOrderList = new HashMap<>();
    }

    public void notifyAll(Order order){
        for(Observer observer:observers){
            observer.notify(order);
        }
    }

    public void addOrder(Order order){
        if(!globalOrderList.containsKey(order.getStockName())){
            globalOrderList.put(order.getStockName(),new OrderBook());
        }
        OrderBook stockOrders = globalOrderList.get(order.getStockName());
        if(order.getOrderType()== OrderType.Buy)
            stockOrders.addBuyOrder(order);
        else stockOrders.addSellOrder(order);
    }


    public void executeOrders(){
        List<Order> executedOrders = new ArrayList<>();
        for(String stockName:globalOrderList.keySet()){
            executedOrders.addAll(globalOrderList.get(stockName).matchOrders());
        }
        for(Order order:executedOrders)
            notifyAll(order);
    }
}
