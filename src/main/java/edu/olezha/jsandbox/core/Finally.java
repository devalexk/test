package edu.olezha.jsandbox.core;

public class Finally {

    public static void main(String[] args) {
        some();
    }

    private static void some() {
        try {
            some();
        } finally {
            some();
        }
    }
}
