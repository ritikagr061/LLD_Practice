package appender;

import entities.LogEvent;

public interface Appender {
    public void append(LogEvent log);
}
