package com.fa.demo.utils;

import org.apache.log4j.Logger;

public class TestUtils {

    final static Logger logger = Logger.getLogger(TestUtils.class);

    public static String getCallerClassNameFromThread() {

        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return stackTraceElement.getClassName();
    }

}
