package edu.olezha.jsandbox.java8.intf.diamond.inheritance;

public interface L2b extends L1 {

    default String someMethod() {
        return "L2b";
    };
}
