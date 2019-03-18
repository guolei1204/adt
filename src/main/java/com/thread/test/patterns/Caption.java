package com.thread.test.patterns;

public class Caption {

    private  static  Caption caption = null;
    private Caption() {
    }

    public static  Caption getInstance(){
        if (caption == null) {
            synchronized (Caption.class){
                if (caption == null) {
                    caption = new Caption();
                    return  caption;
                }
            }
        }
        return  caption;
    }

    public static void main(String[] args) {
        Caption c1 = Caption.getInstance();
        Caption c2 = Caption.getInstance();
        System.out.println(c1 == c2);
    }
}
