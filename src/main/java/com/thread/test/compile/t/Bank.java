package com.thread.test.compile.t;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;
    private Lock bankLock;
    private Condition condition;

    public Bank(double[] accounts, double initialBalance) {
        this.accounts = accounts;
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        condition = bankLock.newCondition();
    }

    public void trasfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        while (accounts[from] < amount) {
            condition.await();
        }

        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);

        accounts[to] += amount;
        System.out.printf("Total balance: %10.2f%n", getTotal());
        System.out.println("accounts:"+ Arrays.toString(accounts));
        condition.signalAll();
    }

    private double getTotal() {
        bankLock.lock();

        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        } finally {
            bankLock.unlock();
        }

    }

    private int size() {
        return accounts.length;
    }

    public static void main(String[] args) {
        double[] accounts = new double[100];
        Bank bank = new Bank(accounts, 1000);
        for (int i = 0; i < 100; i++) {
            int fromAccount = i;
            Runnable r = () -> {

                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double exchange = 1000 * Math.random();
                        bank.trasfer(fromAccount, toAccount, exchange);
                        Thread.sleep(Math.round(10 * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
