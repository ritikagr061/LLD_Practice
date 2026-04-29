package entities;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationRequest {
    private List<Channel> channels;
    private int receiverUserId;
    private String subject;
    private String content;
    private byte[] attachment;
    private LocalDateTime scheduledTime;

    private NotificationStatus status;

    public NotificationRequest(Builder builder){
        this.receiverUserId = builder.receiverUserId;
        this.subject = builder.subject;
        this.content = builder.content;
        this.attachment = builder.attachment;
        this.scheduledTime = builder.scheduledTime;
        this.channels = builder.channels;
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public static class Builder{
        private final List<Channel> channels;
        private final int receiverUserId;
        private String subject;
        private final String content;
        private byte[] attachment;
        private LocalDateTime scheduledTime;

        public Builder(int receiverUserId, String content, List<Channel> channels){
            this.receiverUserId= receiverUserId;
            this.content = content;
            this.channels = channels;
        }

        public Builder subject(String subject){
            this.subject = subject;
            return this;
        }

        public Builder attachment(byte[] attachment){
            this.attachment = attachment;
            return this;
        }

        public Builder scheduledTime(LocalDateTime time){
            this.scheduledTime = time;
            return this;
        }

        public NotificationRequest build(){
            return new NotificationRequest(this);
        }
    }

}
