package dinamiclogging;

import it.scp.logging.CommonLoggingClass;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DynaLogging {
    public static void main(String[] args) {
        new DynaLogging().start();
    }

    private void start() {

        String[] ups = new String[] {"RC", "RM", "TO"};

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        for (String up : ups) {
            Task t = new Task(up);
            executor.execute(t);
        }

        executor.shutdown();
    }
}

class Task implements Runnable {

    private String up;

    Task(String up) {
        this.up = up;
    }

    @Override
    public void run() {
        try {

            System.out.println("Current thread name " + Thread.currentThread().getName());

            Logger logger = Logger.getLogger(Thread.currentThread().getName());
            SimpleLayout simpleLayout = new SimpleLayout();
            FileAppender fileAppender = new FileAppender(simpleLayout, "C:/appslogs/"+ up+"-dynaLog.log", false);
            logger.setLevel(Level.DEBUG);
            logger.addAppender(fileAppender);


            LoggingClass loggingClass = new LoggingClass(up, logger);
            loggingClass.doLog();
            CommonLoggingClass commonLoggingClass = new CommonLoggingClass(up);
            commonLoggingClass.doSomeLog();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

class LoggingClass {

    private String up;
    private Logger logger;

    LoggingClass(String up, Logger logger) {
        this.up = up;
        this.logger = logger;
    }

    public void doLog() {

        logger.debug(up + " Here is some DEBUG");
        logger.info(up + " Here is some INFO");
        logger.warn(up + " Here is some WARN");
        logger.error(up + " Here is some ERROR");
        logger.fatal(up + " Here is some FATAL");

    }
}

