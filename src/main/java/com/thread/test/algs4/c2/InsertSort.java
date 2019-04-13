package com.thread.test.algs4.c2;


public class InsertSort {

    private InsertSort() {
    }

    public static void sort(Comparable[] input) {
        int n = input.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(input[j], input[j - 1]); j--) {
                System.out.println("j:" + j);
                SelectionSort.show(input);
                exchange(input, j, j - 1);
            }
        }
    }

    public static void sort1(Comparable[] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            Comparable item_i = input[i];
            while (index > 0 && !less(input[index - 1], item_i)) {
                input[index] = input[index - 1];
                index--;
            }
            input[index] = item_i;
        }

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] input, int a, int b) {
        Comparable tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{21, 7, 9, 66, 28, 62, 28, 98};
        InsertSort.sort1(input);
        SelectionSort.show(input);
    }
}
