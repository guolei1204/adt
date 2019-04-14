package com.thread.test.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> implements Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    @Override
    public void regist(Observer observer) {
        System.out.println("register:" + observer.toString());
        observers.add(observer);
    }

    @Override
    public void unregist(Observer observer) {
        System.out.println("unregister:" + observer.toString());
        observers.remove(observer);
    }

    @Override
    public void nodifyAll(T value) {
        for (Observer<T> observer : observers) {
            observer.update(value);
        }
    }
}
