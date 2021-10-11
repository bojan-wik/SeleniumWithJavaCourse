package Chapter25_Log4j.beta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo2 {

    private static final Logger logger = LogManager.getLogger(Demo2.class.getName());

    public static void main(String[] args) {

        logger.debug("debug message");
        logger.info("info message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
}
