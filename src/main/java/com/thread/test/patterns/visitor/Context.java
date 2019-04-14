package com.thread.test.patterns.visitor;

public class Context {
    public static void main(String[] args) {
        System.out.println("visitor pattern ");
        Visitor visitor = new ConcreateVisitor();
        Original myClass = new MyClass(99);
        myClass.visit(visitor);
    }
}
