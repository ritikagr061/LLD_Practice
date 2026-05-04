package entities;

import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderBook {
    private TreeMap<Integer, Queue<Order>> buyBook;
    private TreeMap<Integer, Queue<Order>> sellBook;

    public OrderBook(){
        buyBook = new TreeMap<>(Collections.reverseOrder());
        sellBook = new TreeMap<>();
    }

    public void addBuyOrder(Order order){
        if(!buyBook.containsKey(order.getBidPrice())){
            buyBook.put(order.getBidPrice(),new LinkedList<>());
        }
        Queue<Order> orders = buyBook.get(order.getBidPrice());
        orders.offer(order);
    }

    public void addSellOrder(Order order){
        if(!sellBook.containsKey(order.getBidPrice())){
            sellBook.put(order.getBidPrice(),new LinkedList<>());
        }
        Queue<Order> orders = sellBook.get(order.getBidPrice());
        orders.offer(order);
    }

    public List<Order> matchOrders(){
        List<Order> matchedOrders=new ArrayList<>();
        while(true){
            int highestBuy = buyBook.firstKey();
            int lowestSell = sellBook.firstKey();
            if(highestBuy>=lowestSell){
                if(buyBook.get(highestBuy).peek().getQuantityRemaining()<=sellBook.get(lowestSell).peek().getQuantityRemaining()){
                    Order buyOrder = buyBook.get(highestBuy).poll();
                    buyOrder.setQuantityRemaining(0);
                    buyOrder.setStatus(OrderStatus.Completed);
                    matchedOrders.add(buyOrder);
                }
                if(buyBook.get(highestBuy).peek().getQuantityRemaining()>=sellBook.get(lowestSell).peek().getQuantityRemaining()){
                    Order sellOrder = buyBook.get(highestBuy).poll();
                    sellOrder.setQuantityRemaining(0);
                    sellOrder.setStatus(OrderStatus.Completed);
                    matchedOrders.add(sellOrder);
                }
            }
            else{
                break;
            }
        }
        return matchedOrders;
    }

}
