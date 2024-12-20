package org.example;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSetup {

    private static final Logger logger = Logger.getLogger(LoggerSetup.class.getName());

    public static void setupLogger() throws IOException {
        LogManager.getLogManager().reset();
        var fileHandler = new FileHandler("application.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
    }

    public static Logger getLogger() {
        return logger;
    }
}
