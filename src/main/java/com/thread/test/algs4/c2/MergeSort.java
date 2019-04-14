package com.thread.test.algs4.c2;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{21, 7, 9, 66, 28, 62, 28, 98};
        MergeSort.mergeSort(input);
        SelectionSort.show(input);
    }

    public static void mergeSort(Comparable[] input) {
        sort(input, 0, input.length - 1);
    }

    private static void sort(Comparable[] src, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(src, lo, mid);
        sort(src, mid + 1, hi);
        merge(src, lo, mid, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] array, int low, int mid, int high) {
        Comparable[] helper = array.clone();
        // merge array[low...mid] and array[mid + 1...high]
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            // k means current location
            if (i > mid) {
                // no item in left part
                array[k] = helper[j];
                j++;
            } else if (j > high) {
                // no item in right part
                array[k] = helper[i];
                i++;
            } else
                if (!less(helper[i], helper[j])) {
                // get smaller item in the right side
                array[k] = helper[j];
                j++;
            } else {
                // get smaller item in the left side
                array[k] = helper[i];
                i++;
            }
        }
    }

}
