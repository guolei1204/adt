package com.thread.test.concurency.phase;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements  Runnable{
    private  static  final  int FHASE= 5;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch doneLantch;

    private  final  int context;

    private static final Random random = new Random(1283182L);

    public MyTask(CyclicBarrier cyclicBarrier, CountDownLatch doneLantch, int context) {
        this.cyclicBarrier = cyclicBarrier;
        this.doneLantch = doneLantch;
        this.context = context;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < FHASE; i++) {
                doPhase(i);
                cyclicBarrier.await();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e){
           e.printStackTrace();
        } finally {
            doneLantch.countDown();
        }
    }

    private void doPhase(int i) {
        String name  = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN: context" + context + " ----- phase"  + i);
        try{
            Thread.sleep(random.nextInt(3000));
        }catch (InterruptedException e){
        }finally {
            System.out.println(name + ":MyTask:END: context" + context + "phase"  + i);
        }
    }
}
