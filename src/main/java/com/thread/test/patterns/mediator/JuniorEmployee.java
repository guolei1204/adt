package com.thread.test.patterns.mediator;

public class JuniorEmployee extends Employee {

    public JuniorEmployee(Mediator mediator,String name) {
        super(mediator);
        this.name = name;
    }


    @Override
    String employeeType() {
        return "Junior Employee";
    }
}
