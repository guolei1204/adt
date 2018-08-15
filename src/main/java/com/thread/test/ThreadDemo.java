package com.thread.test;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void main(String[] args) {
        PrimeGenerator p = new PrimeGenerator();
        p.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.interrupt();
        System.out.println("t status"+p.getState());
        System.out.println("is interrupted" + p.isInterrupted());
        System.out.println("is alive" + p.isAlive());
    }
}

