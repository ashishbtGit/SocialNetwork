package com.socialnetwork.api.utils;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

public class RestLogger {
    private static Logger Log = Logger.getLogger(RestLogger.class);

    public static void startTestCase(String TestCaseName){
        Log.info("--------"+TestCaseName +"----------------");
    }

    public static void endTestCase(){
        Log.info("--------"+ "End Of Test" +"----------------");
    }

    public static void info(String message){
        Log.info(message);
    }

}
