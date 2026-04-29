package entities.channel;

import entities.NotificationManager;
import entities.NotificationRequest;
import entities.user.UserReciever;

import java.util.Optional;

public class SMSChannelSender implements ChannelSender {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        Optional<UserReciever> user = NotificationManager.users.stream()
                .filter((UserReciever receiver) -> receiver.getUserId() == request.getReceiverUserId())
                .findFirst();
        if (user.isEmpty()) {
            return false;
        }
        user.get().getInbox().addMessage("SMS: " + request.getContent());
        return true;
    }
}
