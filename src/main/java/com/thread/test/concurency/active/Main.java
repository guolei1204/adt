package com.thread.test.concurency.active;


import com.thread.test.concurency.DisplayThread;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerThread("aClient", activeObject).start();
        new MakerThread("bClient", activeObject).start();
        new DisplayThread("display",activeObject).start();
    }
}
