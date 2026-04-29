package entities.channel;

import entities.NotificationRequest;

public interface ChannelSender {
    boolean sendNotification(NotificationRequest request);
}
