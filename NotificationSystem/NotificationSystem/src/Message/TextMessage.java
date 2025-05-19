package Message;

public class TextMessage implements Message{
    String content;
    @Override
    public Object extractContent() {
        return content;
    }
}
