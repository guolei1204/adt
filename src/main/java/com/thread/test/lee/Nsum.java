package com.thread.test.lee;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nsum {
    public static void main(String[] args) {
        int target = 0;
        int[] intput = new int[]{1, 0, -1, 0,-2 , 2};
        List<List<Integer>> rr = fourSumBest(intput, target);
        for (List<Integer> integers : rr) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    public static List<List<Integer>> fourSumBest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int nl = nums.length;
        for (int i = 0; i < nl - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
//            if (nums[i] + nums[nl - 3] + nums[nl - 2] + nums[nl - 1] < target) continue;
            for (int j = i + 1; j < nl - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
//                if (nums[i] + nums[j] + nums[nl - 2] + nums[nl - 1] < target) continue;
                int left = j + 1, right = nl - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) right--;
                    if (sum < target) left++;
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }
}
