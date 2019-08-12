package com.thread.test.concurency.active;

public class RealResult<T> extends  Result<T>{
    private final  T realValue;
    public RealResult(T realValue) {
        this.realValue = realValue;
    }
    @Override
    public T getResultValue() {
        return realValue;
    }
}
