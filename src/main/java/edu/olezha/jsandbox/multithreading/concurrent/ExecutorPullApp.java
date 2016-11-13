package edu.olezha.jsandbox.multithreading.concurrent;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by oleh on 13.11.16.
 */
public class ExecutorPullApp {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new ImplementsCallableSingleProcess("Name" + i)));
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
