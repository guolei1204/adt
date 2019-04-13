package com.thread.test.algs4.c1;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{8,6,9,13,7,72,54,89,33,52,98};
        int n = 7;
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        int r = search(input, n);
        System.out.println(r);
    }

    private static int search(int[] input, int n) {
        int hi = input.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (n < input[mid]) {
                hi = mid - 1;
            } else if (n > input[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
