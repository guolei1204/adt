package com.thread.test.concurency;

import java.util.Random;

public class UserThread extends Thread {
    private final static Random random = new Random(9999);
    private final Resource resource;

    public UserThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true){
                resource.use();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource(3);
        for (int i = 0;i< 10 ;i++){
            new UserThread(resource).start();
        }
    }
}
