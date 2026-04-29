package entities.Inbox;

import java.util.ArrayList;
import java.util.List;

public class SMS implements Inbox{
    List<String> messages;

    public SMS() {
        this.messages = new ArrayList<>();
    }
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessages(String content){
        messages.add(content);
    }

    @Override
    public List<String> getInbox() {
        return messages;
    }

    @Override
    public void addMessage(String message) {
        messages.add(message);
    }
}