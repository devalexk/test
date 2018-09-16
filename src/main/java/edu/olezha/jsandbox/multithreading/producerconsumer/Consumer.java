package edu.olezha.jsandbox.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Consumer implements Runnable {

    private final BlockingQueue<String> queue;

    private final AtomicBoolean stop;

    private final AnswerConsumer answerConsumer;

    Consumer(final BlockingQueue<String> queue, final AtomicBoolean stop, final AnswerConsumer answerConsumer) {
        this.queue = queue;
        this.stop = stop;
        this.answerConsumer = answerConsumer;
    }

    @Override
    public void run() {
        System.out.println("Consumer start");
        while (!stop.get()) {
            try {
                final String item = queue.poll(1, TimeUnit.MILLISECONDS);
                if (queue.size() > 1_000)
                    answerConsumer.found(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer finish");
    }
}
