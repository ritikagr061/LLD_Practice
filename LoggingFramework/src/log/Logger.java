package log;

import appender.Appender;
import appender.ConsoleAppender;
import entities.LogEvent;
import entities.LogLevel;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {
    private final LogLevel maxLevel;
    private final String className;
    private List<Appender> appenders;
    public Logger(LogLevel maxLevel, Class<?> clazz){
        this.maxLevel = maxLevel;
        this.className = clazz.getName();
        this.appenders = new CopyOnWriteArrayList<>(); // for thread safety
    }

    public void debug(String message){
        if(!checkLogAllowed("debug"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Debug);
        log.setMessage(message);
        log.setStackTrace("");
        log(log);
    }
    public void info(String message){
        if(!checkLogAllowed("info"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Info);
        log.setMessage(message);
        log.setStackTrace("");
        log(log);
    }
    public void warn(String message){
        if(!checkLogAllowed("warn"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Warn);
        log.setMessage(message);
        log.setStackTrace("");
        log(log);
    }

    public void error(String message){
        if(!checkLogAllowed("error"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Error);
        log.setMessage(message);
        log.setStackTrace("");
        log(log);
    }

    public void debug(String message, Throwable throwable){
        if(!checkLogAllowed("debug"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Debug);
        log.setMessage(message);
        log.setStackTrace(throwable.getStackTrace().toString());
        log(log);
    }
    public void info(String message, Throwable throwable){
        if(!checkLogAllowed("info"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Info);
        log.setMessage(message);
        log.setStackTrace(throwable.getStackTrace().toString());
        log(log);
    }
    public void warn(String message, Throwable throwable){
        if(!checkLogAllowed("warn"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Warn);
        log.setMessage(message);
        log.setStackTrace(throwable.getStackTrace().toString());
        log(log);
    }

    public void error(String message, Throwable throwable){
        if(!checkLogAllowed("error"))
            return;
        LogEvent log = createNewLog();
        log.setLevel(LogLevel.Error);
        log.setMessage(message);
        log.setStackTrace(throwable.getStackTrace().toString());
        log(log);
    }

    public boolean checkLogAllowed(String level){
        return switch (level) {
            case "debug" -> maxLevel == LogLevel.Debug;
            case "info" -> (maxLevel == LogLevel.Debug || maxLevel == LogLevel.Info);
            case "warn" -> (maxLevel != LogLevel.Error);
            case "error" -> true;
            default -> false;
        };
    }

    public LogEvent createNewLog(){
        LogEvent newLog = new LogEvent();
        newLog.setClassName(this.className);
        return newLog;
    }

    public void log(LogEvent log){
        for(Appender appender:appenders){
            //appender = ConsoleAppender.getInstance();
            appender.append(log);
        }
    }
}
