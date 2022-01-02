package com.thread.test.fun;

import scala.Int;

import java.util.Arrays;

public class F1 {
    public static String reverse(String res){
        String[] rr = res.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = rr.length; i > 0; i--) {
            sb.append(rr[i-1]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Integer num = 11;
        while (true){
            if(
                    num.toString().equals(reverse(num.toString()))&&
                            Integer.toBinaryString(num).equals(reverse(Integer.toBinaryString(num)))&&
                            Integer.toOctalString(num).equals(reverse(Integer.toOctalString(num)))
            ){
                System.out.println(num);
                break;
            }
            num +=2;
        }
    }
}
