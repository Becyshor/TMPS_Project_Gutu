package main.java.com.utm.datasource;

import main.java.com.utm.enitity.Car;
import main.java.com.utm.enitity.Owner;

import java.util.ArrayList;
import java.util.List;

public class SingletonDb {
    private static SingletonDb SINGLE_INSTANCE = null;

    private final List<Car> cars = new ArrayList<>();

    private SingletonDb() {}
    public static SingletonDb getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized(SingletonDb.class) {
                SINGLE_INSTANCE = new SingletonDb();
            }
        }
        return SINGLE_INSTANCE;
    }

    public void addCar(Car car) {
        if (car != null) {
            cars.add(car);
        }
    }

    public void removeCar(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public Car getCar(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getOwnerCars(Owner owner) {
        List<Car> currentCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getOwner().equals(owner)) {
                currentCars.add(car);
            }
        }
        return currentCars;
    }

}
