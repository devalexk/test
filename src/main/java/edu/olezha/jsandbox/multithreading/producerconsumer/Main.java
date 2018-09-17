package edu.olezha.jsandbox.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static AtomicBoolean stop = new AtomicBoolean(false);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        executorService.submit(new Producer(queue, stop));
        executorService.submit(new Consumer(queue, stop, Main::found));

        while (!stop.get())
            if (queue.size() > 400)
                executorService.submit(new Consumer(queue, stop, Main::found));

        executorService.shutdown();
    }

    private static void found(String answer) {
        stop.set(true);
        System.out.println("answer: " + answer);
    }
}
