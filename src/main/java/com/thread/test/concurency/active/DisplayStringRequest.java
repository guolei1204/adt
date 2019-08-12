package com.thread.test.concurency.active;

public class DisplayStringRequest extends MethodRequest<Object>{

    private final String message;

    public DisplayStringRequest(Servant servant, String message) {
        super(servant,null);
        this.message = message;
    }
    @Override
    public void execute() {
        servant.display(message);
    }
}
