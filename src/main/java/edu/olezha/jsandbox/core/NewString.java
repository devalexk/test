package edu.olezha.jsandbox.core;

public class NewString {

    public static void main(String[] args) {
        String firstString = "ABC";
        String secondString = "ABC";
        System.out.println("same str: " + (firstString == secondString));

        firstString = "BCD";
        secondString = new String("BCD");
        System.out.println("new: " + (firstString == secondString));

        final String secondString2 = "BCD";
        System.out.println("final: " + (firstString == secondString2));

        final String partOfSecondString3 = "BC";
        String secondPart = "D";
        System.out.println("final + str: " + (secondString2 == partOfSecondString3 + secondPart));

        firstString = "DEF";
        secondString = new String("DEF").intern();
        System.out.println("intern: " + (firstString == secondString));

        firstString = new String("EFG");
        secondString = firstString.intern();
        System.out.println("intern2: " + (firstString == secondString));

        StringBuilder sb = new StringBuilder(secondString);
        System.out.println("sb-str: " + secondString.equals(sb));

        StringBuilder sb2 = new StringBuilder(secondString);
        System.out.println("sb-sb: " + sb.equals(sb2));
    }
}
