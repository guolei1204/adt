package com.thread.test.fun;



import java.util.*;

public class F4 {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{500, 100, 50, 10};
        change(1000, arr, 15);
        System.out.println("=========================");
        System.out.println(count);
    }

    private static void change(int target, int[] coins, int unused) {
        //从硬币中选择一个金额， 余额剩下的硬币分。硬币的剩余个数不能大于15
        int coin = coins[0];
        if (coins.length == 0) {
            if (target / coin < unused) {
                ++count;
                System.out.println(count);
            }
        } else {
            for (int i = 0; i < target / coin; i++) {
                int[] clone = clone(coins);
                change(target - coin * i, clone, unused - i);
            }
        }
    }

    private static int[] clone(int[] coins) {
        for (int i = 0; i < coins.length - 1; i++) {
            coins[i] = coins[i + 1];
        }
        return Arrays.copyOf(coins, coins.length - 1);
    }
}
