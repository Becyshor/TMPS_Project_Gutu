package main.java.com.utm.enitity.administration;

import main.java.com.utm.enitity.CarServiceEntity;
import main.java.com.utm.enitity.Repair;

import java.util.ArrayList;
import java.util.List;

public class Director extends CarServiceEntity implements Staff {

    private static Director director = null;
    private final List<Administrator> administration = new ArrayList<>();

    private Director() {}

    public static Director getInstance() {
        if (director == null) {
            director = new Director();
        }
        return director;
    }

    @Override
    public Repair resolveIssue(Repair repair) {
        Administrator assigned = getFreeAdministrator();
        if (assigned != null) {
            assigned.setFree(false);
            repair.setResolution(repair.getResolution() + "Director assigned admin with id = {" + assigned.getName() + "}. \n");
            return assigned.resolveIssue(repair);
        }
        return null;
    }

    private Administrator getFreeAdministrator() {
        for (Administrator administrator : administration) {
            if (administrator.isFree()) {
                return administrator;
            }
        }
        return null;
    }

    public List<Administrator> getAdministration() {
        return administration;
    }
}
