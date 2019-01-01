package com.thread.test.compile.rect;

import com.thread.test.compile.ToString;
import com.thread.test.compile.rect.Point;

@ToString
public class Rectangle {
    private Point topLeft;
    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @ToString(includeName = false)
    public Point getLeftPoint() {
        return topLeft;
    }
    @ToString
    public int getWidth(){
        return width;
    }

    @ToString
    public int getHeight(){
        return height;
    }
}
