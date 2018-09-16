package edu.olezha.jsandbox;

public class CatchSame {

    public static void main(String[] args) {
        try {
            throw new NullPointerException("npe 1");
        } catch (NullPointerException npe) {
            throw new NullPointerException("mpe 2");
        } finally {
            return;
        }
    }
}
