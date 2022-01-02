package com.thread.test.fun;

public class F3 {
    public static void main(String[] args) {
        cut(3,20);
        cut(5,100);
    }
    //拼接木棍逆向思维 木棍单位长度为1
    // m people ; n stick length
    public static  void cut(int m,int n){
       int count = 0;
       int current = 1;
       while (n > current) {
           current += current <  m? current :m;
           ++count;
       }
        System.out.println(count);
    }
}
