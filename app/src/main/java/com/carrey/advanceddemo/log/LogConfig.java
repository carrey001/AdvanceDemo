package com.carrey.advanceddemo.log;

/**
 * class:  LogConfig
 * auth:  carrey
 * date: 16-11-26.
 * desc:
 */

public class LogConfig {




    public static String formatJson(String json){

        return "";
    }

    public static String formatXml(String xml){

        return "";
    }

    public static String formatThrowable(Throwable throwable) {
        return "";
//        return XLog.sLogConfiguration.throwableFormatter.format(throwable);
    }

    public static String formatThread(Thread thread) {
        return "";

//        return XLog.sLogConfiguration.threadFormatter.format(thread);
    }
    public static String formatStackTrace(StackTraceElement[] stackTrace) {
        return "";
//        return XLog.sLogConfiguration.stackTraceFormatter.format(stackTrace);
    }
    public static String addBorder(String[] segments) {
        return "";
//        return XLog.sLogConfiguration.borderFormatter.format(segments);
    }

}
