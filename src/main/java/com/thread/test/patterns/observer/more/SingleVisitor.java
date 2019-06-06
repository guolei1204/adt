package com.thread.test.patterns.observer.more;

public class SingleVisitor implements Visitor{
    @Override
    public void visit(Beijing city) {
        System.out.println("visit beijing");
    }

    @Override
    public void visit(ShangHai city) {
        System.out.println("visit shanghai");
    }

    @Override
    public void visit(Guangzhou city) {
        System.out.println("visit guangzhou");
    }
}
