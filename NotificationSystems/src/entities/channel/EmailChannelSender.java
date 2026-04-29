package entities.channel;

import entities.NotificationManager;
import entities.NotificationRequest;
import entities.user.UserReciever;

import java.util.Optional;

public class EmailChannelSender implements ChannelSender {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        Optional<UserReciever> user = NotificationManager.users.stream()
                .filter((UserReciever receiver) -> receiver.getUserId() == request.getReceiverUserId())
                .findFirst();
        if (user.isEmpty()) {
            return false;
        }

        String subject = request.getSubject() == null ? "No Subject" : request.getSubject();
        user.get().getInbox().addMessage("EMAIL: " + subject + " | " + request.getContent());
        return true;
    }
}
