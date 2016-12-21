package edu.olezha.jsandbox.math;

import java.math.BigDecimal;

public class BigDecimalMain {

    public static void main(String[] args) {
        int priceKop = 9999;
        BigDecimal price = BigDecimal.valueOf(priceKop, 2);
        
        System.out.println(price);
    }

}
