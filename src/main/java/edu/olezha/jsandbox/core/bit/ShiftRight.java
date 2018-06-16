package edu.olezha.jsandbox.core.bit;

public class ShiftRight {

    public static void main(String[] args) {
        shiftRight(1024, 10);
        System.out.println("---");
        shiftRight(63, 7);
        System.out.println("---");
        shiftRight(-63, 7);
    }

    private static void shiftRight(int a, int j) {
        for (int i = 0; i < j; i++) {
            System.out.println("---");
            int c = a >> 1;
            System.out.println(a + " >> " + 1 + " = " + c + " = " + a + " / 2");
            System.out.println(
                    Integer.toBinaryString(a)
                            + " >> "
                            + Integer.toBinaryString(1)
                            + " = "
                            + Integer.toBinaryString(c)
            );
            a = c;
        }
    }
}
