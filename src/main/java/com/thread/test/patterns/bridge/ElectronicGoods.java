package com.thread.test.patterns.bridge;

abstract class ElectronicGoods {
    protected State state;

    public ElectronicGoods(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public void moveToCurrentState(){
        System.out.println("the electronic item is functional at :" );
        state.moveState();
    }

    public void hardButtonPressed(){
        state.hardPressed();
    }
}



