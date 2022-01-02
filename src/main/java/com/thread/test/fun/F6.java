package com.thread.test.fun;

import java.util.Arrays;

public class F6 {
    public static void main(String[] args) {
        int boy = 21;
        int girl = 11;
        int[][] arr = new int[boy][girl];

        arr[0][0] =1;

        for (int i = 0; i < girl; i++) {
            for (int j = 0; j < boy; j++) {
                if((i!=j)&&(boy -j != girl -i) ){
                    if(j > 0){
                        arr[i][j] += arr[i][j -1];
                    }
                    if(i > 0){
                        arr[i][j] += arr[i-1][j];
                    }
                }
            }
        }
        int rr = arr[girl - 2][boy - 1] + arr[girl - 1][boy - 2];
    }
}
