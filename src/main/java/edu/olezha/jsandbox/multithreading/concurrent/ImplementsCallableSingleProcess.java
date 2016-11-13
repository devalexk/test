package edu.olezha.jsandbox.multithreading.concurrent;

import java.util.concurrent.Callable;

/**
 * Created by oleh on 13.11.16.
 */
public class ImplementsCallableSingleProcess implements Callable<String> {

    private String name;

    public ImplementsCallableSingleProcess() {}

    public ImplementsCallableSingleProcess(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        Thread.sleep((long) 1e3);
        System.out.println("ImplementsCallableSingleProcess done");
        return "ImplementsCallableSingleProcessCallable<String>: " + name + " (the best option)";
    }

}
