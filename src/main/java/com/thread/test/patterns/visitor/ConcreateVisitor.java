package com.thread.test.patterns.visitor;

public class ConcreateVisitor  implements Visitor{
    @Override
    public void visit(MyClass myClass) {
        System.out.println("current value of my Int " + myClass.getValue());
        System.out.println("visitor will make double value of my Int");
        System.out.println("current value of my Int is " + 2 * myClass.getValue());
        System.out.println("exit from Visitor");
    }
}
