package com.thread.test.patterns.chain;

public class Demo {
    public static void main(String[] args) {
        System.out.println("*** chain of responsibility");

        IssueRaiser issueRaiser = new IssueRaiser();
        FaxErrorHandler faxHandler = new FaxErrorHandler();
        EmailErrorHandler emailHandler = new EmailErrorHandler();

        issueRaiser.setFirstReceiver(faxHandler);
        faxHandler.nextErrorHandler(emailHandler);
        emailHandler.nextErrorHandler(null);

        Message m1 = new Message("Fax is going slow", MessagePriority.NOMAL);
        Message m2 = new Message("Email are not reaching", MessagePriority.HIGHT);
        Message m3 = new Message("In Email cc field is displayed aways", MessagePriority.NOMAL);
        Message m4 = new Message("Fax is not reaching destinations", MessagePriority.NOMAL);


        issueRaiser.raiseMessage(m1);
        issueRaiser.raiseMessage(m2);
        issueRaiser.raiseMessage(m3);
        issueRaiser.raiseMessage(m4);
    }
}
