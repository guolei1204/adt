package com.thread.test.lee;


//#7 整数翻转 32位有符号整数
public class RevertInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            System.out.println(pop);
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = reverse(120);
        System.out.println(result);
    }
}
