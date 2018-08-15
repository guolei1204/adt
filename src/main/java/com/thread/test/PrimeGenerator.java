package com.thread.test;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long num = -1L;
        while (true){
            if(isPrime(num)){
                System.out.printf("Number %d is Prime \n",num);
            }
            if (isInterrupted()){
                System.out.printf("the prime generator has been interrupted \n");
                return;
            }
            num ++;
        }
    }

    private boolean isPrime(long num) {
        if(num < 2){
            return true;
        }
        for(long i = 2; i < num;i++){
            if((num % i) == 0){
                return false;
            }
        }
        return false;
    }
}
