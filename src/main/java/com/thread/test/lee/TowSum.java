package com.thread.test.lee;

import java.util.Arrays;
//#1
public class TowSum {
    public  static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] results = new int[2];
        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j < len;j++){
                if(nums[i] + nums[j] == target){
                    results[0]=i;
                    results[1]=j;
                }
            }
        }
        return  results;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
