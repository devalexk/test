package edu.olezha.jsandbox.multithreading.producerconsumer;

@FunctionalInterface
interface AnswerConsumer {

    void found(String answer);
}
