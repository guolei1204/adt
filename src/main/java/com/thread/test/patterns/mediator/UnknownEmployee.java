package com.thread.test.patterns.mediator;

public class UnknownEmployee extends Employee {
    public UnknownEmployee(Mediator mediator) {
        super(mediator);
    }

    @Override
    String employeeType() {
        return "Unknown Employee";
    }
}
