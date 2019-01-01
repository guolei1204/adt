package com.thread.test.compile;

import com.thread.test.compile.rect.Point;
import com.thread.test.compile.rect.Rectangle;

public class SourceAnnotationDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(new Point(10, 10), 20, 30);
        System.out.println(ToStrings.toString(rect));
    }
}
