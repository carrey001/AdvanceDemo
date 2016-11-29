package com.carrey.advanceddemo.log;


/**
 * class:  Logger
 * auth:  carrey
 * date: 16-11-26.
 * desc:
 */

public class Logger {

    private LogConfig mLogConfig;
    private Printer mPrinter;

    Logger(LogConfig logConfig, Printer printer) {
        mLogConfig = logConfig;
        mPrinter = printer;
    }
//    Logger(Builder builder) {
//
//    }

    public void v(Object object){
        println("",object);
    }

    private void println(String Tag, Object object) {

    }


//    public class Builder {
//
//    }
}
