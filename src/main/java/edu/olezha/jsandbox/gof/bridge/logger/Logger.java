package edu.olezha.jsandbox.gof.bridge.logger;

interface Logger {

    LoggerImpl loggerImpl = new STLoggerImpl();

    default void log(String message) {
        loggerImpl.logImpl(message);
    }
}
