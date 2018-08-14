package edu.olezha.jsandbox.gof.bridge.logger;

class SocketLogger implements Logger {

    @Override
    public void log(String message) {
        loggerImpl.logImpl(message + " (socket)");
    }
}
