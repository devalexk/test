package edu.olezha.jsandbox.memory;

import java.util.HashMap;
import java.util.Map;

public class OutOfMemoryHeapSpaceSimulator {

    private static Map<String, OutOfMemoryHeapSpaceSimulator> leackContainer = new HashMap<>();
    private static final String dataPrefix = "DATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATADATA";

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            for (int i = 0; i < 10000000; i++) {
                String data = dataPrefix + i;
                leackContainer.put(data, new OutOfMemoryHeapSpaceSimulator());
                Thread.sleep(1);
            }
        } catch (Throwable e) {
            System.out.println("OutOfMemoryHeapSpaceSimulator Failure: " + e);
        }
        System.out.println("OutOfMemoryHeapSpaceSimulator END");
    }
}
