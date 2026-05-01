package entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class LogEvent {
    private LocalDateTime timestamp;
    private LogLevel level;
    private String message;
    private String stackTrace;
    private int traceId;
    private String className;

    public LogEvent(LogLevel level, String message, String stackTrace, int traceId, String className) {
        this.timestamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
        this.stackTrace = stackTrace;
        this.traceId = traceId;
        this.className = className;

    }
    public LogEvent(){
        this.timestamp = LocalDateTime.now();
    }
}
