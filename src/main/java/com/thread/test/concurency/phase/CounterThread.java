package com.thread.test.concurency.phase;

public class CounterThread  extends  Thread{
    private long counter = 0;

    private  volatile  boolean isShutdown = false;

    public  void  shutdownRequest(){
        isShutdown = true;
        interrupt();
    }

    public  boolean isShutdown(){
        return isShutdown;
    }


    @Override
    public void run() {
        try {
            while (!isShutdown) {
                doWork();
            }
        }catch (InterruptedException e){

        }finally {
            doShutdown();
        }
    }

    private void doShutdown() {
        System.out.println("doshutdown  counter is "+ counter);
    }

    private void doWork() throws  InterruptedException{
        counter ++ ;
        System.out.println("do work ; counter =" + counter);
        Thread.sleep(500);
    }
}
