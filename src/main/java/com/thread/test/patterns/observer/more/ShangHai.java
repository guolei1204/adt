package com.thread.test.patterns.observer.more;

public class ShangHai implements City {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
