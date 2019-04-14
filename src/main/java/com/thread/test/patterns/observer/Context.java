package com.thread.test.patterns.observer;

public class Context {

    public static void main(String[] args) {

        Observer<Integer> t1 = new ObType1<Integer>(1);
        System.out.println(t1);
        Observer<Integer> t2 = new ObType2<Integer>(2);
        System.out.println(t2);

        Observable subject = new Subject();
        subject.regist(t1);
        subject.regist(t2);
        subject.nodifyAll(99);

    }
}
