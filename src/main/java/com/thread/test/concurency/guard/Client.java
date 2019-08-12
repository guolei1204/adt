package com.thread.test.concurency.guard;

import java.util.Random;

public class Client extends  Thread{
    private  final Random random;

    private final  RequestQueue requestQueue;

    public Client(RequestQueue requestQueue,String name,long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000 ; i++) {
            Request request = new Request("no"+i);
            System.out.println(Thread.currentThread().getName() + "client request "+ request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
