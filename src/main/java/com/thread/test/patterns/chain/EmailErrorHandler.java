package com.thread.test.patterns.chain;

public class EmailErrorHandler implements Receiver {
    private Receiver nextReceiver;

    @Override
    public boolean handleMessage(Message message) {
        if (message.getText().contains("Email")) {
            System.out.println("EmailErrorHanlder processed "+ message.getMessagePriority() + " priority issue :" + message.getText());
            return true;
        } else {
            if (nextReceiver != null) {
                nextReceiver.handleMessage(message);
            }
        }
        return false;
    }

    @Override
    public void nextErrorHandler(Receiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }
}
