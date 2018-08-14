package edu.olezha.jsandbox.gof.bridge.logger;

class MTLoggerImpl implements LoggerImpl {

    @Override
    public void logImpl(String message) {
        System.out.println(message + " (multithreaded)");
    }
}
