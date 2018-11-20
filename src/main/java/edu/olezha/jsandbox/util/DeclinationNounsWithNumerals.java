package edu.olezha.jsandbox.util;

import com.ibm.icu.text.MessageFormat;

import java.util.Locale;

public class DeclinationNounsWithNumerals {

    public static void main(String[] args) {
        String pattern = "{0,plural,one{# публікація}" +
                "few{# публікації}" +
                "many{# публікацій}" +
                "other{# публікація}}";

        MessageFormat msgFormat = new MessageFormat(pattern, new Locale("uk"));

        for (int i : new int[] {0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 15, 17, 22, 39, 51, 101, 111, 121, 200, 201, 1010, 1011, 1012})
            System.out.println(msgFormat.format(new Object[] {i}));
    }
}
