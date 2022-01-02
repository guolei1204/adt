package com.thread.test.fun;

public class F15 {
    public static final int N = 10;
    public static final int STEPS = 4;

    public static void main(String[] args) {
        move(0,0, N);
    }

    public static void move(int count, int a, int b) {
        if (a > b)
            return;
        if (a == b)
            return;
        for (int i = 0; i < STEPS; i++) {
            for (int j = 0; j < STEPS; j++) {
                System.out.println(count);
                move(count, a + i, b - j);
            }
        }
    }
}
