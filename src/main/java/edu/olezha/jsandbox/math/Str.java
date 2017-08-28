package edu.olezha.jsandbox.math;

public class Str {

    public static void main(String[] args) {
        String firstString = "ABC";
        String secondString = "ABC";
        System.out.println(firstString == secondString);

        firstString = "BCD";
        secondString = new String("BCD");
        System.out.println(firstString == secondString);

        firstString = new String("CDE");
        secondString = "CDE";
        System.out.println(firstString == secondString);

        firstString = "DEF";
        secondString = new String("DEF").intern();
        System.out.println(firstString == secondString);

        firstString = new String("EFG");
        secondString = firstString.intern();
        System.out.println(firstString == secondString);
    }

}
