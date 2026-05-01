package appender;

import entities.LogEvent;

public class ConsoleAppender implements Appender{

    public static class Holder{
        public static final Appender instance = new ConsoleAppender();
    }
    public static Appender getInstance(){
        return Holder.instance;
    }
    private ConsoleAppender(){
        //sets up config
    }
    @Override
    public synchronized void append(LogEvent log) {
        System.out.println(log.toString());
    }
}
