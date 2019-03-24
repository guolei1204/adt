package com.thread.test.lee.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> s =  new ArrayList();
        int n = 4;
        backtrack(s,"",0,0,n);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    private static void backtrack(List<String> ls, String current, int open, int close, int max) {
        if(current.length() == max * 2){
            ls.add(current);
            return;
        }
        if(open < max){
            backtrack(ls,current + "(" ,open +1,close,max);
        }
        if(close < open){
            backtrack(ls,current + ")",open,close +1,max);
        }
    }

}
