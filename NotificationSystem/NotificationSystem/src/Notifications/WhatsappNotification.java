package Notifications;

import Message.Message;

public class WhatsappNotification extends NotificationProcessor{
    public WhatsappNotification(Message m) {
        super(m);
    }
    @Override
    public void sendNotification() {
        System.out.println("Sending whatsapp notiifacaiton: "+ message.extractContent());
    }
}
