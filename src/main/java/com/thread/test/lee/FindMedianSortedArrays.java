package com.thread.test.lee;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l12  = l1 + l1;
        int[] all = new int[l12];

        System.arraycopy(nums1,0,all,0,l1);
        System.arraycopy(nums2,0,all,l1,l2);
        Arrays.sort(all);
        int l = ((all.length + 1)/2)-1;
        if ((all.length +1)%2 ==0){
            return all[l];
        }else {
            return(all[l] + all[l+1])/2.0;
        }
    }

    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(result);
    }

}
