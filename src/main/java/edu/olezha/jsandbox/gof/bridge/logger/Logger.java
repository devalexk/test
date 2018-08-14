package edu.olezha.jsandbox.gof.bridge.logger;

interface Logger {

    LoggerImpl loggerImpl = new MTLoggerImpl();

    default void log(String message) {
        loggerImpl.logImpl(message);
    }
}
