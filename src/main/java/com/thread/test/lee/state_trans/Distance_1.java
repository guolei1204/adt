package com.thread.test.lee.state_trans;

public class Distance_1 {
    public static void main(String[] args) {
        System.out.println(getStringDistance("mouse","mouuse"));
    }

    public static int getStringDistance(String a , String b ){
        if (a == null || b == null) return -1;

        int[][] d = new int[a.length() +1 ][b.length() + 1];
        for(int j = 0; j <= b.length(); j ++ ){
            d[0][j] = j;
        }
        for(int i = 0;i<a.length()+1;i ++){
            d[i][0] = i;
        }

        for(int i = 0;i < a.length() ;i ++ ){
            for (int j = 0; j <b.length(); j++) {
                int r = 0;
                if(a.charAt(i) != b.charAt(j)){
                    r = 1;
                }
                int first_append = d[i][j+1] + 1;
                int second_append = d[i+1][j] +1;
                int replace = d[i][j] +r;
                int min = Math.min(first_append,second_append);
                min  = Math.min(min,replace);
                d[i+1][j+1]  = min;
            }
        }

        return d[a.length()][b.length()];
    }
}
