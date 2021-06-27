package main.java.com.utm.controllers;

import main.java.com.utm.service.CarService;

public class PrototypeTestController {

    private CarService carService;

    public PrototypeTestController(CarService carService) {
        this.carService = carService; //passing the service through constructor
    }

    public CarService getCarService() {
        return carService;
    }
}
