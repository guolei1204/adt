package com.thread.test.algs4.c2;

public class ShellSort {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{19, 1, 10, 14, 16, 4, 7, 9, 3, 2, 8, 5, 11};
        shellSort(input);
        SelectionSort.show(input);
    }


    private static void shellSort(Comparable[] input) {
        int n = input.length;

        // ** start with a big gap ,then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            /**
             * do a gapped insertion sort for this gap size.
             * the first gap elements a[a .. gap -1] are already
             * in gapped order keep adding  one more element
             * until the entire array is gap sorted
             */
            for (int i = gap; i < n; i += 1) {
                /**
                 * add a[i] to the elements that have been gap sorted
                 * save a[i] in temp and make a hole at position i
                 */
                Comparable tmp = input[i];
                /**
                 * shift earlier gap-sorted elements up until the correct location for a[i] is found
                 */
                int j;
                for (j = i; j >= gap && input[j - gap].compareTo(tmp) > 0; j -= gap) {
                    input[i] = input[j - gap];
                }
                input[j] = tmp;
            }
        }
    }
}
