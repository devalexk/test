package edu.olezha.jsandbox.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        /*
         * @See https://docs.oracle.com/javase/tutorial/datetime/iso/overview.html
         */

        LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 6, 23, 36);
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.from(localDateTime);
        System.out.println(localDate);

        LocalDate localDate2 = localDate.plusMonths(1);
        System.out.println(localDate2 + " " + localDate);
    }
}
