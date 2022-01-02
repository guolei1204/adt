package com.thread.test.fun;

import java.util.Arrays;

public class F2 {
    private static final int[] arr = new int[100];
    private static final boolean[] position = new boolean[100];

    static {
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <100; i++) {
            int j = i + 1;
            for (; j < 100; j = j+(i +2)) {
                position[j] = !position[j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(position[i]==false) {
                System.out.println(arr[i]);
            }
        }
    }
}
