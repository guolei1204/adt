package com.thread.test.lee;

public class LongestCommonPrefix {

    public static String m1(String[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int fl = args[0].length();
        for (int i = 0; i < fl; i++) {
            char curr = args[0].charAt(i);
            for (int j = 1; j < args.length; j++) {
                if(i > args[j].length() || args[j].charAt(i) != curr){
                    return sb.toString();
                }
            }
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{
                "flower", "flow", "floght"
        };
        String r = m1(arr);
        System.out.println(r);
    }
}
