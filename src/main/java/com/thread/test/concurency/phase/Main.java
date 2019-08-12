package com.thread.test.concurency.phase;

public class Main {
    public static void main(String[] args) {
        CounterThread t  = new CounterThread();
        t.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("main :shutdown request ");
        t.shutdownRequest();

        System.out.println("main join");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
