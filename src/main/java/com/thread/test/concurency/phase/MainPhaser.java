package com.thread.test.concurency.phase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPhaser {
    private static final  int THREADS = 3;
    public static void main(String[] args) {
        System.out.println("MAIN begin");
        ExecutorService service = Executors.newFixedThreadPool(THREADS);
        Runnable barriaerAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction");
            }
        };

        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS,barriaerAction);


        CountDownLatch downLatch = new CountDownLatch(THREADS);

        try{
            for (int i = 0; i <THREADS ; i++) {
                service.execute(new MyTask(phaseBarrier,downLatch,i));
            }
        } finally {
            service.shutdown();
            System.out.println("Main end");
        }
    }
}
