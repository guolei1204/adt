package com.thread.test.algs4.c2;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] unsortedArray = new Integer[]{21, 7, 9, 66, 28, 62, 28, 98};
        quickSort(unsortedArray);
        SelectionSort.show(unsortedArray);
    }

    private static void quickSort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }


    //局部有序算法最优解 理解双指针
    private static void sort(Comparable[] array, int l, int r) {
        if (l >= r) return;
        Comparable pivot = array[l];
        int left = l + 1;
        int right = r;

        //双指针,
        while (left <= right) {
            // 如果左边的元素小于右边则移动指针
            while (left <= right && less(array[left], pivot)) {
                left++;
            }
            // 如果右边的元素大于基准 这右边的指针向左移动
            while (left <= right && array[right].compareTo(pivot) >= 0) {
                right--;
            }
            //如果左边的大于右边的则退出
            if (left > right) break;
            //swap 较远指针元素 array[left] array[right] while left <= right
            exchange(array, left, right);
        }
        // swap the smaller with pivot
        exchange(array, right, l);

        sort(array, l, right - 1);
        sort(array, right + 1, r);

    }

    private static void exchange(Comparable[] array, int left, int right) {
        Comparable tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }
}
