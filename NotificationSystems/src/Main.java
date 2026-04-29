import entities.Channel;
import entities.NotificationManager;
import entities.NotificationRequest;
import entities.user.UserReciever;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        NotificationManager.users.add(new UserReciever(1,"ritik"));
        NotificationManager.users.add(new UserReciever(2,"agrawal"));

        NotificationRequest request1 =new NotificationRequest
                .Builder(1,"Hey Ritik", new ArrayList<>(List.of(Channel.SMS))).build();
        NotificationRequest request2 =new NotificationRequest
                .Builder(2,"This is inbox of user 2", new ArrayList<>(List.of(Channel.Email)))
                .subject("Welcome")
                .build();
        NotificationRequest request3 =new NotificationRequest
                .Builder(1,"Multi-channel notification", new ArrayList<>(List.of(Channel.SMS, Channel.Email)))
                .subject("Order Update")
                .build();
        manager.addRequest(request1);
        manager.addRequest(request2);
        manager.addRequest(request3);

        manager.printUserInboxes(); //should print empty
        manager.run();
        manager.printUserInboxes(); //should print messages
    }
}
