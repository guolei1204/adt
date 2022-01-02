package com.spark.test;


import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 7, 12, 29, 3};
        sort(arr);
        System.out.println("=====");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                   swap(arr,i,j);
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
