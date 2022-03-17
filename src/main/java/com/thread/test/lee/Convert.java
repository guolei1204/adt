package com.thread.test.lee;

import java.util.ArrayList;

public class Convert {
    public static  String convert(String s,int rows){
        if(rows == 1) {
            return  s;
        }
        ArrayList<StringBuilder> rs = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(s.length(), rows); i++) {
            rs.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rs.get(currentRow).append(c);
            if(currentRow == 0|| currentRow == rows-1) {
                goingDown =  !goingDown;
            }
            currentRow += goingDown?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder r : rs) {
            result.append(r);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        //        s = "LEETCODEISHIRING", numRows = 4
        String r = convert("LEETCODEISHIRING",  4);
        System.out.println(r);
    }
}
