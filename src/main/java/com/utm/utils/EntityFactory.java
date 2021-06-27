package main.java.com.utm.utils;

import main.java.com.utm.enitity.Car;
import main.java.com.utm.enitity.CarServiceEntity;
import main.java.com.utm.enitity.Owner;
import main.java.com.utm.enitity.Repair;
import main.java.com.utm.enitity.administration.Administrator;
import main.java.com.utm.enitity.administration.Director;
import main.java.com.utm.enitity.administration.Mechanic;

public class EntityFactory implements EntitiesAbstractFactory {
    @Override
    public CarServiceEntity getEntity(String entity) {
        if (entity.equalsIgnoreCase("car")) {
            return new Car();
        } else if (entity.equalsIgnoreCase("owner")) {
            return new Owner();
        } else if (entity.equalsIgnoreCase("repair")) {
            return new Repair();
        } else if (entity.equalsIgnoreCase("administrator")) {
            return new Administrator();
        } else if (entity.equalsIgnoreCase("mechanic")) {
            return new Mechanic();
        } else if (entity.equalsIgnoreCase("director")) {
            return Director.getInstance();
        }
        return null;
    }
}
