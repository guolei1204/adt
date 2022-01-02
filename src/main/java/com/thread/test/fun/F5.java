package com.thread.test.fun;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class F5 {
    private static final int STEPS = 12;
    private static final List<Point> p4 = new ArrayList<>();

    static {
        p4.add(new Point(0, 1));
        p4.add(new Point(0, -1));
        p4.add(new Point(1, 0));
        p4.add(new Point(-1, 0));
    }

    public static void main(String[] args) {
        List<Point> path = new ArrayList<Point>();
        path.add(new Point(0, 0));


    }

    public static int moveNext(int nextStep, List<Point> steps) {
        return 0;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
