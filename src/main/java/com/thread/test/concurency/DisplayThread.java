package com.thread.test.concurency;

import com.thread.test.concurency.active.ActiveObject;

public class DisplayThread extends Thread {
    private final ActiveObject activeObject;

    public DisplayThread(String name,ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                String message = Thread.currentThread().getName() + ":" + i;
                activeObject.display(message);
                Thread.sleep(200);
            }
        }catch (InterruptedException e){}
    }
}
