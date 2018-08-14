package edu.olezha.jsandbox.gof.bridge.logger;

class STLoggerImpl implements LoggerImpl {

    @Override
    public void logImpl(String message) {
        System.out.println(message + " (single threaded)");
    }
}
