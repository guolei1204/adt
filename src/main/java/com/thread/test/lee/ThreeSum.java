package com.thread.test.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(nums));
        //[-4, -1, -1, 0, 1, 2]
        ArrayList<List<Integer>> rr = m1(nums);
        for (List<Integer> integers : rr) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private static ArrayList<List<Integer>> m1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        if (nums[0] >= 0) {
            return result;
        }

        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
            ArrayList<Integer> r = new ArrayList<>(3);
            r.add(0);
            r.add(0);
            r.add(0);
            result.add(r);
        }

        int left, right;

        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[i] + nums[right] == 0) {
                    ArrayList<Integer> r = new ArrayList<>(3);
                    r.add(nums[left]);
                    r.add(nums[i]);
                    r.add(nums[right]);
                    result.add(r);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                } else if (nums[left] + nums[i] + nums[right] > 0) {
                    right = right - 1;
                }
                if (nums[left] + nums[i] + nums[right] < 0) {
                    left = left + 1;
                }
                while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                    i++;
                }
            }
        }
        return result;
    }
}
