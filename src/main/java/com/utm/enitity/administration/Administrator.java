package main.java.com.utm.enitity.administration;

import main.java.com.utm.enitity.CarServiceEntity;
import main.java.com.utm.enitity.Repair;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends CarServiceEntity implements Staff {

    private final List<Mechanic> mechanics = new ArrayList<>();

    private boolean free = true;

    private String name;

    @Override
    public Repair resolveIssue(Repair repair) {
        Mechanic freeMechanic = getFreeMechanic();
        if (freeMechanic != null) {
            return freeMechanic.resolveIssue(repair.setResolution(repair.getResolution() + " admin with id = {" + this.name
                    + "} assigned the task to mechanic with id = {" + freeMechanic.setFree(false).getName() + "}.\n"));
        }
        return null;
    }

    private Mechanic getFreeMechanic() {
        for(Mechanic mechanic : mechanics) {
            if (mechanic.isFree()) {
                return mechanic;
            }
        }
        return null;
    }

    public Administrator setFree(boolean free) {
        this.free = free;
        return this;
    }

    public boolean isFree() {
        return this.free;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public Administrator setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
