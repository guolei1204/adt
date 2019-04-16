package com.thread.test.patterns.chain;

public class IssueRaiser {
    public  Receiver firstReceiver;

    public void setFirstReceiver(Receiver firstReceiver) {
        this.firstReceiver = firstReceiver;
    }

    public  void raiseMessage(Message message){
        if(null!= firstReceiver){
            firstReceiver.handleMessage(message);
        }
    }
}
