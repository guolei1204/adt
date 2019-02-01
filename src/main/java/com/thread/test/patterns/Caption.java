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
}
