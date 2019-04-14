package com.thread.test.patterns.observer;

public class ObType1<T> implements Observer<T> {
    private T t;

    public ObType1(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ObType1 init with value" + t.toString();
    }

    @Override
    public void update(T value) {
        this.t = value;
        System.out.println(this.toString());
    }
}
