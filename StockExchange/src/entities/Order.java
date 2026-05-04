package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Order {
    private static int orderCount=0;
    private OrderType orderType;
    private int bidPrice;
    private String stockName;
    private LocalDateTime orderCreatedAt;
    private int sequenceId;
    private int quantityRemaining;
    private int originalQuantity;
    private User user;
    private OrderStatus status;

    public Order(){
        sequenceId = orderCount++;
        orderCreatedAt = LocalDateTime.now();
    }
    public Order(OrderType type, int bidPrice, String stockName, int originalQuantity, User user, OrderStatus status){
        this();
        this.orderType = type;
        this.bidPrice = bidPrice;
        this.stockName = stockName;
        this.originalQuantity = originalQuantity;
        this.quantityRemaining = originalQuantity;
        this.user =user;
        this.status= status;
    }
}
