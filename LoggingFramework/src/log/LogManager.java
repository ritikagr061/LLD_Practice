package log;

import entities.LogLevel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LogManager {
    private static LogLevel maxLogLevel=LogLevel.Debug;
    private static String baseFileLoc="C:/logs/";
    private static boolean isAsyncLoggingEnabled= false;
    private static Map<Class<?>,Logger> cache = new ConcurrentHashMap<>();
    public LogManager(){

    }
    //concurrency in static method is handled either by making it sychronized or real question is -> is the method accessing mutable data
    public static Logger getLogger(Class<?> clazz){
        if(!cache.containsKey(clazz)) {
            Logger logger = new Logger(maxLogLevel, clazz);
            cache.put(clazz, logger);
        }
        return cache.get(clazz);
    }
}
