package com.thread.test.concurency;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Resource {
    private  final Semaphore semaphore;
    private  final  int permitions;
    private  final  static Random random = new Random(189932);

    public Resource(int permitions) {
        this.semaphore = new Semaphore(permitions);
        this.permitions = permitions;
    }

    public  void use() throws  InterruptedException{
        semaphore.acquire();
        try{
            doUse();
        }finally {
            semaphore.release();
        }
    }

    private void doUse() throws InterruptedException {
        Log.println("Begin: use ="+ (permitions - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End:use =" + (permitions - semaphore.availablePermits()));

    }
}
