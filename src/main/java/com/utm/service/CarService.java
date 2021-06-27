package main.java.com.utm.service;

import main.java.com.utm.datasource.SingletonDb;
import main.java.com.utm.enitity.Car;

public class CarService implements ServicePrototype {

    private final SingletonDb singletonDb = SingletonDb.getInstance();

    public void registerNewCar(Car car) {
        singletonDb.addCar(car);
    }

    public SingletonDb getSingletonDb() { //getter for testing the singleton pattern
        return singletonDb;
    }

    public Car getCarById(Long id) {
        return singletonDb.getCar(id);
    }

    @Override
    public ServicePrototype makeCopy() {
        CarService carService = null;
        try {
            carService = (CarService) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return carService;
    }
}
