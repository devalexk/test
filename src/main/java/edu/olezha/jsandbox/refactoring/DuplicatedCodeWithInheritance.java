package edu.olezha.jsandbox.refactoring;

import java.util.ArrayList;
import java.util.List;

class A {

    private String some;

    A(String some) {
        this.some = some;
    }
}

class B extends A {

    private String other;

    B(String some, String other) {
        super(some);
        this.other = other;
    }
}

public class DuplicatedCodeWithInheritance {

    public List<A> processA() {
        List<A> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new A(get(i)));
        }
        return list;
    }

    public List<B> processB() {
        List<B> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new B(get(i), get(i)));
        }
        return list;
    }

    private String get(int i) {
        return Integer.toString(i);
    }
}
