package com.thread.test.patterns.bridge;

public class DVD extends ElectronicGoods {
    public DVD(State state) {
        super(state);
    }

    public void doublePress(){
        state.hardPressed();
        state.hardPressed();
    }
}
