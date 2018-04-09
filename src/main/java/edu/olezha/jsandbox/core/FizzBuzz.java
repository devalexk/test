package edu.olezha.jsandbox.core;

/*
 * Write a program that
 * - print the numbers from 1 to 100
 * - But for multiples of the three print "Fizz" instead of the number
 * - and for the multiplies of five print "Buzz".
 * - For numbers which are miltiples of both three and five print "FizzBuzz".
 */
public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    System.out.println("FizzBuzz");
                    continue;
                }
                System.out.println("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                System.out.println("Buzz");
                continue;
            }
            System.out.println(i);
        }
    }
}
