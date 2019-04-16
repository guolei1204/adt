package com.thread.test.patterns.mediator;

abstract class Employee {
    private  Mediator mediator;

    public Employee(Mediator mediator) {
        this.mediator = mediator;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    abstract String employeeType();
}
