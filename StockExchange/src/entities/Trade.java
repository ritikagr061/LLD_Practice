package entities;

import java.util.ArrayList;
import java.util.List;

public class Trade {
    private List<String> executedTrades;
    public Trade(){
        executedTrades = new ArrayList<>();
    }
    public void addTrade(String entity){
        executedTrades.add(entity);
    }
}
