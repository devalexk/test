package edu.olezha.jsandbox.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Consumer implements Runnable {

    private final BlockingQueue<String> queue;

    private final AtomicBoolean stop;

    private final AnswerConsumer answerConsumer;

    Consumer(final BlockingQueue<String> queue, final AtomicBoolean stop, final int i, final AnswerConsumer answerConsumer) {
        this.queue = queue;
        this.stop = stop;
        this.answerConsumer = answerConsumer;
        System.out.println("Consumer " + i);
    }

    @Override
    public void run() {
        while (!stop.get()) {
            try {
                final String p = queue.poll(100, TimeUnit.MILLISECONDS);
                if (p == null) continue;
                System.out.println("q: " + queue.size() + "; v: " + p);
                if (queue.size() > 500)
                    answerConsumer.found(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
