package entities.user;

import entities.Inbox.Inbox;
import entities.Inbox.SMS;

public class UserReciever implements User {
    private int userId;
    private String userName;
    public UserReciever(int userId,String userName){
        this.userId = userId;
        this.userName = userName;
        this.inbox = new SMS();
    }
    private Inbox inbox;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Inbox getInbox() {
        return inbox;
    }

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }
}
