package edu.olezha.jsandbox.gof.bridge.logger;

class Main {

    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        logger.log("hi there");
    }
}
