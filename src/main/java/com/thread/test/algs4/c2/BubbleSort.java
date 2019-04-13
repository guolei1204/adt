package com.thread.test.algs4.c2;

public class BubbleSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if(bigger(a[j-1],a[j])){
                    swap(a,j-1,j);
                }
            }
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean bigger(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Integer[] unsortedArray = new Integer[]{6, 5, 3, 1, 8, 7, 2, 4};
        sort(unsortedArray);
        for (Integer o : unsortedArray) {
            System.out.println(o);
        }
    }
}
