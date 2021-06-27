package main.java.com.utm.service;

public class ServiceFactory {

    public static ServicePrototype getClone(ServicePrototype servicePrototypeSample) {
        return servicePrototypeSample.makeCopy();
    }

}
