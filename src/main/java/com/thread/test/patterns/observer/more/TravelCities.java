package com.thread.test.patterns.observer.more;

public class TravelCities implements City {
    private final City[] cities;

    public TravelCities() {
        cities = new City[]{new Beijing(), new ShangHai(), new Guangzhou()};
    }
    

    @Override
    public void accept(Visitor visitor) {
        for (City city : cities) {
            city.accept(visitor);
        }
    }
}
