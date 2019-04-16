package com.thread.test.patterns.mediator;

public interface Mediator {
    void register(Employee employee);

    void sendMessage(Employee employee,String msg) throws InterruptedException;
}
