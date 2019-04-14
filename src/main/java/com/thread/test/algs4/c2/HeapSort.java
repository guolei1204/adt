package com.thread.test.algs4.c2;

public class HeapSort {


    private void heapify(Comparable[] nums, int n, int i) {
        int largest = i;

        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && nums[l].compareTo(nums[largest]) > 0) {
            largest = l;
        }
        if (r < n && nums[r].compareTo(nums[largest]) > 0) {
            largest = r;
        }
        // if largest is not root
        if (largest != i) {
            Comparable temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, n, largest);
        }
    }


    public void sort(Comparable[] nums) {
        int n = nums.length;

        // build heap
        for (int parent = n / 2 - 1; parent >= 0; parent--) {
            heapify(nums, n, parent);
        }

        // one by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // move current root to end
            Comparable temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{19, 1, 10, 14, 16, 4, 7, 9, 3, 2, 8, 5, 11};
//        String[] input = new String[]{"T","S","R","P","N"};
        HeapSort heapsort = new HeapSort();
        heapsort.sort(input);
        SelectionSort.show(input);
    }
}
