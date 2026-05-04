package observer;

import entities.Order;
import entities.Trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeRepository implements Observer{
    Map<String, List<Trade>> stockTrades;
    private TradeRepository(){
        stockTrades = new HashMap<>();
    }
    public static class Holder{
        public static final TradeRepository instance = new TradeRepository();
    }
    public static TradeRepository getInstance(){
        return Holder.instance;
    }

    @Override
    public void notify(Order order) {
        String stockName = order.getStockName();
        Trade trade = new Trade();
        trade.addTrade(order.toString());
        addTrade(stockName,trade);
    }

    public void addTrade(String stock, Trade trade){
        if(!stockTrades.containsKey(stock))
            stockTrades.put(stock,new ArrayList<>());
        List<Trade> trades = stockTrades.get(stock);
        trades.add(trade);
    }
}
