package com.thread.test.algs4.c2;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        SelectionSort.show(arr);
    }

    private static void radixSort(Integer[] arr, int n) {
        int m = getLargest(arr);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    private static void countSort(Integer[] arr, int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private static int getLargest(Integer[] arr) {
        Integer largest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}
