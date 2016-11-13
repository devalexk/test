package edu.olezha.jsandbox.multithreading.lang;

/**
 * Created by oleh on 13.11.16.
 */
public class SynchroApp {

    public static void main(String[] args) throws InterruptedException {
        SynchroCounter counter = new SynchroCounter();
        SynchroSynchronizedCounter synchronizedCounter = new SynchroSynchronizedCounter();

        for (int i = 0; i < 50; i++) {
            SynchroSingleProcess synchroSingleProcess = new SynchroSingleProcess(counter, synchronizedCounter);
            new Thread(synchroSingleProcess).start();
        }

        Thread.sleep(3000);

        System.out.println(synchronizedCounter.getCounter() + " > " + counter.getCounter());
    }

}
