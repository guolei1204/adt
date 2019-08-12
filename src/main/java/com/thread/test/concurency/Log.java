package com.thread.test.concurency;


public class Log {
    public static  void println(String s){
        System.out.println(Thread.currentThread().getName() +":"+s);
    }
}
