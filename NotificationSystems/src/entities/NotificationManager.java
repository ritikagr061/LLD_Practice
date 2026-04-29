package entities;

import entities.channel.ChannelSender;
import entities.channel.ChannelSenderFactory;
import entities.user.UserReciever;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    public static List<UserReciever> users = new ArrayList<>();
    private List<NotificationRequest> requests;
    private final ChannelSenderFactory channelSenderFactory;

    public NotificationManager(){
        requests = new ArrayList<>();
        channelSenderFactory = new ChannelSenderFactory();
    }

    public void addRequest(NotificationRequest request){
        requests.add(request);
    }

    public void run(){
        for(NotificationRequest req: requests){
            for(Channel channel: req.getChannels()){
                ChannelSender channelSender = channelSenderFactory.getSender(channel);
                channelSender.sendNotification(req);
            }
        }
    }

    public void printUserInboxes(){
        for(UserReciever user: users){
            System.out.println(user.getInbox().getInbox()); //prints list of messages
        }
    }
}
