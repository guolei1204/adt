package com.thread.test.jvm;

public abstract class MyClass {
    protected  long p = 12L;

    {
        p ++;
        System.out.println("father.{}..p="+p);
    }
}
