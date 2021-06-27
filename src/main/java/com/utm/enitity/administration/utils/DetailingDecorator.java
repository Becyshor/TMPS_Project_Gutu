package main.java.com.utm.enitity.administration.utils;

import main.java.com.utm.enitity.Repair;

public class DetailingDecorator implements SpecialityDecorator {

    private Repair repair;

    public DetailingDecorator(Repair repair) {
        this.repair = repair;
    }

    @Override
    public Repair decorateRepair() {
        return repair.setResolution(repair.getResolution() + " + Provided Detailing services \n");
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }
}
