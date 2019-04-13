package com.thread.test.patterns.bridge;

public class OffState  implements  State{
    @Override
    public void moveState() {
        System.out.println("off state");
    }

    @Override
    public void hardPressed() {
        System.out.println("the device is off state. Do not press the off button again");
    }
}
