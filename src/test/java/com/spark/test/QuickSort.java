package com.spark.test;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{33,7,1,9,23,62,13,79,32};
    }

    private static void sort(int[] arr,int start,int end){
        if(start > end){
            return;
        }
        int pivotIndex = parition(arr,start,end);
        sort(arr,start,pivotIndex-1);
        sort(arr,pivotIndex + 1,end);
    }

    private static int parition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left != right){
            while (left < right && arr[right] > pivot){
                right --;
            }
            while (left < right && arr[left] <= pivot){
                left ++;
            }
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] =p;
            }
        }

        arr[start] = arr[left];

        arr[left] = pivot;

        return left;
    }
}
