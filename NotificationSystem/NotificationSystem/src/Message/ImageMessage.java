package Message;

public class ImageMessage implements Message{
    private Object content;
    @Override
    public Object extractContent() {
        return content;
    }
}
