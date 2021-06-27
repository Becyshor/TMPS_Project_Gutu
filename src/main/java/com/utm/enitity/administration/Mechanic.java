package main.java.com.utm.enitity.administration;

import main.java.com.utm.enitity.CarServiceEntity;
import main.java.com.utm.enitity.Repair;

public class Mechanic extends CarServiceEntity implements Staff {

    private boolean free = true;

    private String name;

    @Override
    public Repair resolveIssue(Repair repair) {
        return repair.setResolution(repair.getResolution() +  " mechanic with name {" + this.name + "} " +
                "Fixed the issue with " + repair.getIssue() + "\n");
    }

    public boolean isFree() {
        return free;
    }

    public Mechanic setFree(boolean free) {
        this.free = free;
        return this;
    }

    public Mechanic setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
