package edu.olezha.jsandbox.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main implements AnswerConsumer {

    private static AtomicBoolean stop = new AtomicBoolean(false);

    public static void main(String[] args) {
        final Main main = new Main();
        final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        int consumerCounter = 0;

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Producer(queue, stop));
        executorService.submit(new Consumer(queue, stop, ++consumerCounter, main));

        while (!stop.get()) {
            if (queue.size() > 400)
                executorService.submit(new Consumer(queue, stop, ++consumerCounter, main));
        }
    }

    @Override
    public void found(String answer) {
        stop.set(true);
        System.out.println("answer: " + answer);
    }
}
