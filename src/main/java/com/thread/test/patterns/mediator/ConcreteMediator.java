package com.thread.test.patterns.mediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private List<Employee> participants = new ArrayList<Employee>();

    @Override
    public void register(Employee employee) {
        participants.add(employee);
    }

    @Override
    public void sendMessage(Employee employee, String msg) throws InterruptedException {
        if (participants.contains(employee)) {
            System.out.println(employee.getName() + "post message:" + msg + "     at last time:  " + LocalDateTime.now().toString());
        } else {
            System.out.println("An outer employee " + employee.getName() + "post message:" + msg + "at last time" + LocalDateTime.now().toString());
        }
    }

    public void displayRegisterEmployees() {
        System.out.println("register employees:");
        for (Employee participant : participants) {
            System.out.println(participant.getName());
        }
    }
}
