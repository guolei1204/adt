package com.thread.test.patterns.visitor;

public class MyClass implements Original {

    private final int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
