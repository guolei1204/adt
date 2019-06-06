package com.thread.test.patterns.observer.more;

public class Guangzhou implements City {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
