package com.thread.test.concurency.active;

public class MakerThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.toUpperCase().charAt(0);
    }


    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Result<String> result = activeObject.mkString(i, fillchar);
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName()  + ": value =" + value);

            }
        } catch (InterruptedException e) {
        }
    }
}
