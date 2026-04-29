package entities.Inbox;

import java.util.List;

public interface Inbox {
    public List<String> getInbox();
    public void addMessage(String message);
}
