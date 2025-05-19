package Notifications;

import Message.Message;

public class EmailNotification extends NotificationProcessor{

    public EmailNotification(Message m) {
        super(m);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending Email notification: "+ message.extractContent());
    }
}
