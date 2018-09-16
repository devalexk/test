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
    }

    @Override
    public void run() {
        System.out.println("Producer start");
        while (!stop.get()) {
            System.out.println(queue.size());
            IntStream.range(0, 100).forEach(i -> {
                if (!stop.get()) {
                    queue.add("abc" + i);
                }
            });
        }
        System.out.println("Producer finish");
    }
}
