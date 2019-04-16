package com.thread.test.patterns.mediator;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        Mediator mediator = new ConcreteMediator();
        JuniorEmployee a = new JuniorEmployee(mediator, "Jone");
        JuniorEmployee b = new JuniorEmployee(mediator, "Tome");
        JuniorEmployee c = new JuniorEmployee(mediator, "Gary");
        mediator.register(a);
        mediator.register(b);
        mediator.register(c);

        SeniorEmployee d = new SeniorEmployee(mediator,"Bob");
        SeniorEmployee e = new SeniorEmployee(mediator,"Merry");
        mediator.register(d);
        mediator.register(e);

        mediator.sendMessage(a,"Hi There ! Let us tall about Gof");
        mediator.sendMessage(b,"Hi There ! which pattern ?");
        mediator.sendMessage(a,"Hi There ! Mediator. I suggest.");

        mediator.sendMessage(d,"I am good at it");
        mediator.sendMessage(e,"Me too!");

        UnknownEmployee u = new UnknownEmployee(mediator);

        mediator.sendMessage(u,"Hello Everyone !");
    }


}
