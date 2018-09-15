package edu.olezha.jsandbox.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

class Producer implements Runnable {

    private final BlockingQueue<String> queue;

    private final AtomicBoolean stop;

    Producer(final BlockingQueue<String> queue, final AtomicBoolean stop) {
        this.queue = queue;
        this.stop = stop;
        System.out.println("Producer");
    }

    @Override
    public void run() {
        while (!stop.get()) {
            IntStream.range(0, 10).forEach(i -> {
                if (!stop.get()) {
                    System.out.print(i + " ");
                    queue.add("abc" + i);
                }
            });
            System.out.println("producer finish next 10");
        }
    }
}
