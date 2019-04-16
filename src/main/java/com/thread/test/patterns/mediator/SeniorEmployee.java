package com.thread.test.patterns.mediator;

public class SeniorEmployee extends Employee {


    public SeniorEmployee(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    String employeeType() {
        return "Senior Employee";
    }
}
