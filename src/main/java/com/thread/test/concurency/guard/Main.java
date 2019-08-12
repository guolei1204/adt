package com.thread.test.concurency.guard;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new Client(requestQueue,"client",18329L).start();
        new Server(requestQueue,"server",8322342L).start();
    }
}
