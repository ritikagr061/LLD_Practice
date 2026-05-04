package observer;

import entities.Order;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements Observer{
    private List<User> users;

    @Override
    public void notify(Order order) {
        User user = order.getUser();
        user.addOrder(order);
        System.out.println("Order executed for user: "+user.getUserName()+ " : "+order.toString());
    }
    public static UserManager getInstance(){
        return Holder.instance;
    }
    private static class Holder{
        public static final UserManager instance = new UserManager();
    }
    private UserManager(){
        users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
    }
}
