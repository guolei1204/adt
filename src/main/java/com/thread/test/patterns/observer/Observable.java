package com.thread.test.patterns.observer;

public interface Observable<T> {
    void regist(Observer<T> observer);

    void unregist(Observer<T> observer);

    void nodifyAll(T value);
}
