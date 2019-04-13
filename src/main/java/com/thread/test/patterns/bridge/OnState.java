package com.thread.test.patterns.bridge;

public class OnState implements State {
    @Override
    public void moveState() {
        System.out.println("on state");
    }

    @Override
    public void hardPressed() {
        System.out.println("the device is already on do not press the button so hard");
    }
}
