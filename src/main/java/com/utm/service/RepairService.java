package main.java.com.utm.service;

import main.java.com.utm.datasource.SingletonDb;
import main.java.com.utm.enitity.Car;
import main.java.com.utm.enitity.Repair;
import main.java.com.utm.utils.EntityFactory;

import java.util.List;

public class RepairService {

    private final SingletonDb singletonDb = SingletonDb.getInstance();
    private final EntityFactory entityFactory = new EntityFactory();

    public void registerNewRepair(Car car, String issue, Long issueId) {
        car.getRepairs().add(((Repair) entityFactory.getEntity("repair")).setIssue(issue).setId(issueId));
    }

    public void resolveIssue(Repair repair, String resolution) {
        repair.setResolution(resolution);
    }

    public SingletonDb getSingletonDb() { //getter for testing the singleton pattern
        return singletonDb;
    }

    public Repair getRepairByCarIdAndRepairId(Long id, Long repairId) {
        List<Repair> repairList =  singletonDb.getCar(id).getRepairs();
        for(Repair repair : repairList) {
            if (repair.getId().equals(repairId)) {
                return repair;
            }
        }
        return null;
    }

}
