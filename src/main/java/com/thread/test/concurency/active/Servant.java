package com.thread.test.concurency.active;

public class Servant implements  ActiveObject{
    @Override
    public Result<String> mkString(int count, char filterChar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count ; i++) {
            buffer[i] = filterChar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult<>(new String(buffer));
    }
    @Override
    public void display(String message) {
        try{
            System.out.println("displayString" + message);
           Thread.sleep(10);
        }catch (InterruptedException e){}
    }
}
