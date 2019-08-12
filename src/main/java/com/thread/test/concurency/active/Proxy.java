package com.thread.test.concurency.active;

public class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final  Servant servant;
    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> mkString(int count, char filterChar) {
        FutureResult<String> futureResult = new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant,futureResult,count,filterChar));
        return  futureResult;
    }
    @Override
    public void display(String message) {
        scheduler.invoke(new DisplayStringRequest(servant,message));
    }
}
