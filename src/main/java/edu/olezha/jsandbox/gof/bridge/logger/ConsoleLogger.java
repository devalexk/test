package edu.olezha.jsandbox.gof.bridge.logger;

class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        loggerImpl.logImpl(message + " (console)");
    }
}
