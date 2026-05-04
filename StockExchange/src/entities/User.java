package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<Order> orders;
    public User(int id, String name){
        userId = id;
        userName = name;
        orders = new ArrayList<>();
    }
    public void addOrder(Order order){
        orders.add(order);
    }
}
