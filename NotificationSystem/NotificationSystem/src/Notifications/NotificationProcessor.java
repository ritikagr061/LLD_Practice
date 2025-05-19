package Notifications;

import Message.Message;

public abstract class NotificationProcessor {
    protected Message message;
    public NotificationProcessor(Message m){
        message=m;
    }
    public abstract void sendNotification();

}

