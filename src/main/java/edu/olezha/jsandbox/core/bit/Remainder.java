package edu.olezha.jsandbox.core.bit;

import java.math.BigInteger;

public class Remainder {

    public static void main(String[] args) {
        long numerator_high_bits = 1373939984L;
        long numerator_low_bits = -7064461968232883232L;
        long denominator = 50754506830109L;

        System.out.printf("%25s%s%n", "remainder: ",
                remainder(numerator_high_bits, numerator_low_bits, denominator));
        System.out.printf("%25s%s%n", "BigInteger.remainder: ",
                BigInteger.valueOf(99689463345168L)
                        .multiply(BigInteger.valueOf(254236690803646L))
                        .remainder(BigInteger.valueOf(denominator))
        );
    }

    public static long remainder(long num_hi, long num_lo, long denom) {
        System.out.printf("%64s%64s%n",Long.toBinaryString(num_hi), Long.toBinaryString(num_lo));
        System.out.printf("%128s%n", Long.toBinaryString(denom));

        return -1;
    }
}
