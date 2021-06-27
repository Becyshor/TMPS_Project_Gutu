package main.java.com.utm.utils;

import main.java.com.utm.enitity.CarServiceEntity;

public interface EntitiesAbstractFactory {

    CarServiceEntity getEntity(String entity);

}
