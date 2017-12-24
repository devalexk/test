package edu.olezha.jsandbox.core;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by oleh on 24.12.17.
 */
@Data
public class Person {

    private Long id;
    private String name;
    private BigDecimal rate;
}
