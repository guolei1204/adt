package com.thread.test.concurency.active;

public  interface  ActiveObject {
    Result<String> mkString(int count, char filterChar);
    void display(String message);
}
