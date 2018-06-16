package edu.olezha.jsandbox.core.bit;

import java.math.BigInteger;

public class MultiplyLong {

    public static void main(String[] args) {
        long x = 99689463345168L, y = 254236690803646L;
        System.out.println(x + " * " + y + "  = " + multiply(x, y));
        System.out.println("BigInteger.multiply               = "
                + BigInteger.valueOf(x).multiply(BigInteger.valueOf(y)));
    }

    /**
     * for non-negative operands
     */
    public static BigInteger multiply(long x, long y) {
        System.out.println(Long.toBinaryString(x) + "  *  " + Long.toBinaryString(y));

        final long x_hi = x >>> 32;
        final long y_hi = y >>> 32;
        final long x_lo = x & 0xFFFFFFFFL;
        final long y_lo = y & 0xFFFFFFFFL;
        System.out.println(Long.toBinaryString(x_hi) + " " + Long.toBinaryString(x_lo)
                + " *  " + Long.toBinaryString(y_hi) + "   " + Long.toBinaryString(y_lo));

        long highHalf = x_lo * y_lo;
        highHalf >>>= 32;
        highHalf += x_hi * y_lo + x_lo * y_hi;
        highHalf >>>= 32;
        highHalf += x_hi * y_hi;

        long lowHalf = 0;
        while (y != 0) {
            if ((y & 1) == 1) {
                lowHalf += x;
            }
            x <<= 1;
            y >>>= 1;
        }

        return new BigInteger(Long.toBinaryString(highHalf) + Long.toBinaryString(lowHalf), 2);
    }
}
