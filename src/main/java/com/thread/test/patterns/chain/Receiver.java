package com.thread.test.patterns.chain;

interface  Receiver {
    boolean handleMessage(Message message);
    void nextErrorHandler(Receiver nextReceiver);
}
