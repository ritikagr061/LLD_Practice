import entities.User;
import observer.UserManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(101,"Ritik");
        User user2 = new User(101,"Nitin Kamath");
        UserManager userManager =UserManager.getInstance();
        userManager.addUser(user1);
        userManager.addUser(user2);


    }
}