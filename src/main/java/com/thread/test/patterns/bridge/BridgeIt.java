package com.thread.test.patterns.bridge;

public class BridgeIt {
    public static void main(String[] args) {
        OnState on = new OnState();
        ElectronicGoods tv = new TV(on);
        tv.setState(on);
        tv.moveToCurrentState();
        tv.hardButtonPressed();

        OffState off = new OffState();

        tv.setState(off);
        tv.moveToCurrentState();


        OnState dvdOn = new OnState();
        ElectronicGoods dvd = new DVD(dvdOn);
        dvd.setState(dvdOn);
        dvd.moveToCurrentState();

        OffState dvdOff = new OffState();
        dvd = new DVD(dvdOff);
        dvd.moveToCurrentState();

        ((DVD) dvd).doublePress();
    }
}
