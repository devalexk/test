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
        return process(true);
    }

    public List<B> processB() {
        return process(false);
    }

    private List process(boolean isA) {
        List list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String some = get(i);

            if (isA) {
                list.add(new A(some));
            } else {
                String other = get(i);
                list.add(new B(some, other));
            }
        }
        return list;
    }

    private String get(int i) {
        return Integer.toString(i);
    }
}
