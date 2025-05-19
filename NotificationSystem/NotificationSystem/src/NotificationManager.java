import Message.Message;
import Notifications.EmailNotification;
import Notifications.NotificationProcessor;
import Notifications.WhatsappNotification;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationManager {
    private Queue<NotificationProcessor> pendingNotifications;
    private NotificationManager(){
        pendingNotifications= new LinkedList<>();
    }
    private static NotificationManager instance;
    public static NotificationManager getInstance(){
        if(instance==null){
            instance=new NotificationManager();
        }
        return instance;
    }
    public synchronized void AddNotification(Message m,String medium ){
        NotificationProcessor p=null;
        if(medium.equalsIgnoreCase("whatsapp"))
            p=new WhatsappNotification(m);
        else if(medium.equalsIgnoreCase("email"))
            p=new EmailNotification(m);
        pendingNotifications.offer(p);
    }

    public synchronized void executeNotification(){

    }
}
