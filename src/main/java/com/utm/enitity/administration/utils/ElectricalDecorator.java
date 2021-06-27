package main.java.com.utm.enitity.administration.utils;

import main.java.com.utm.enitity.Repair;

public class ElectricalDecorator implements SpecialityDecorator {

    private Repair repair;

    public ElectricalDecorator(Repair repair) {
        this.repair = repair;
    }

    @Override
    public Repair decorateRepair() {
        return this.repair.setResolution(repair.getResolution() + " + Provided electrical services \n");
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }
}
