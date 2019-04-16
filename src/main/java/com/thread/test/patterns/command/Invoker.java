package com.thread.test.patterns.command;

public class Invoker {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }

}
