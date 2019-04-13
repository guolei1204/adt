package com.thread.test.algs4.c2;

public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n ;j++){
                if(less(a[j],a[min])) min = j;
            }
            exchange(a,i,min);
        }
    }



    private static void exchange(Comparable[] a, int i, int min) {
        Comparable tmp = a[i];
        a[i] = a[min];
        a[min] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] intput = new Integer[]{21,7,9,66,28,62,28,98};
        SelectionSort.sort(intput);
        show(intput);
    }

    public static void show(Comparable[] intput) {
        for (int i = 0; i < intput.length; i++) {
            System.out.print(intput[i]+" ");
        }
        System.out.println();
    }
}
