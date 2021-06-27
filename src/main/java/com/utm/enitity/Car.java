package main.java.com.utm.enitity;

import java.util.ArrayList;
import java.util.List;

public class Car extends CarServiceEntity {

    private Long id;
    private String brand;
    private String model;
    private Owner owner;
    private String vinCode;
    private String plate;
    private String engine;
    private List<Repair> repairs = new ArrayList<>();

    public Car(CarBuilder carBuilder) {
        this.id = carBuilder.id;
        this.brand = carBuilder.brand;
        this.model = carBuilder.model;
        this.owner = carBuilder.owner;
        this.vinCode = carBuilder.vinCode;
        this.plate = carBuilder.plate;
        this.engine = carBuilder.engine;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public static class CarBuilder {
        private Long id;
        private String brand;
        private String model;
        private Owner owner;
        private String vinCode;
        private String plate;
        private String engine;

        public CarBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public CarBuilder setVinCode(String vinCode) {
            this.vinCode = vinCode;
            return this;
        }

        public CarBuilder setPlate(String plate) {
            this.plate = plate;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Long getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Owner getOwner() {
            return owner;
        }

        public String getVinCode() {
            return vinCode;
        }

        public String getPlate() {
            return plate;
        }

        public String getEngine() {
            return engine;
        }
    }
}
