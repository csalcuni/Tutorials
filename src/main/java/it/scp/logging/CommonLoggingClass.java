package it.scp.logging;

import org.apache.log4j.Logger;

public class CommonLoggingClass {

    private Logger logger = Logger.getLogger(Thread.currentThread().getName());
    private String up;

    public CommonLoggingClass(String up) {
        this.up = up;
    }

    public void doSomeLog() {

        logger.debug(up + " CommonLoggingClass Here is some DEBUG");
        logger.info(up + " CommonLoggingClass Here is some INFO");
        logger.warn(up + " CommonLoggingClass Here is some WARN");
        logger.error(up + " CommonLoggingClass Here is some ERROR");
        logger.fatal(up + " CommonLoggingClass Here is some FATAL");
    }

}
