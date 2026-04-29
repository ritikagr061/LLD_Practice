package entities.channel;

import entities.Channel;

public class ChannelSenderFactory {
    public ChannelSender getSender(Channel channel) {
        switch (channel) {
            case SMS:
                return new SMSChannelSender();
            case Email:
                return new EmailChannelSender();
            default:
                throw new IllegalArgumentException("Unsupported channel: " + channel);
        }
    }
}
