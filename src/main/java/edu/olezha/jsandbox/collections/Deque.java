package edu.olezha.jsandbox.collections;

import java.util.ArrayDeque;

/**
 * Created by oleh on 12.11.16.
 */
public class Deque {

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            String e = "E" + i;
            System.out.println(e);
            deque.push(e);
        }

        System.out.println("--------------");

        while (deque.peek() != null) {
            System.out.println(deque.pollLast());
            System.out.println(deque.pollFirst());
        }
    }

}
