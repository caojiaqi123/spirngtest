package com.smart.model.dirtype;

public class CarFactory {
    public Car createHongQi(){
        Car car = new Car();
        car.setBrand("红旗");
        return car;
    }

    public static Car createCar(){
        Car car = new Car();
        return car;
    }
}
