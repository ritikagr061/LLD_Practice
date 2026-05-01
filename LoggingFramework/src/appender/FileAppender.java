package appender;

import entities.LogEvent;

public class FileAppender implements Appender{
    public static class Holder{
        public static final Appender instance = new FileAppender();
    }
    public static Appender getInstance(){
        return Holder.instance;
    }
    private FileAppender(){
        //sets up config
    }
    @Override
    public synchronized void append(LogEvent log) {
        System.out.println("Assume that this is getting printed in a file :)");
        System.out.println(log.toString());
    }
}
