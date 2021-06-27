package main.java.com.utm.controllers;

import main.java.com.utm.enitity.Car;
import main.java.com.utm.enitity.Owner;
import main.java.com.utm.enitity.Repair;
import main.java.com.utm.enitity.administration.Administrator;
import main.java.com.utm.enitity.administration.Director;
import main.java.com.utm.enitity.administration.Mechanic;
import main.java.com.utm.enitity.administration.utils.ElectricalDecorator;
import main.java.com.utm.service.CarService;
import main.java.com.utm.service.RepairService;
import main.java.com.utm.utils.EntityFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainTestController {

    private CarService carService = new CarService();
    private PrototypeTestController prototypeTestController = new PrototypeTestController((CarService) carService.makeCopy());
    private RepairService repairService = new RepairService();
    EntityFactory entityFactory = new EntityFactory();

    @GetMapping("/singleton")
    public ResponseEntity<?> runSingletonTest() {
        try {
            System.out.println("Verifying whether a singleton created object is the same on in two different services");
            return new ResponseEntity<>(carService.getSingletonDb() == repairService.getSingletonDb(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/prototype")
    public ResponseEntity<?> runPrototypeTest() {
        try {
            System.out.println("Testing if prototype based service is different to the original one, created in SingletonTestController");
            System.out.println(carService == prototypeTestController.getCarService());
            return new ResponseEntity<>(carService == prototypeTestController.getCarService(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/car/add")
    public ResponseEntity<?> registeringNewCarUsingBuilder(@RequestParam("id") int id,
                                              @RequestParam("brand") String brand,
                                              @RequestParam("model") String model,
                                              @RequestParam("ownerName") String ownerName,
                                              @RequestParam("ownerGender") String ownerGender,
                                              @RequestParam("vin") String vin,
                                              @RequestParam("plate") String plate,
                                              @RequestParam("engine") String engine) {
        try {
            System.out.println("Building new Car using Builder");
            carService.registerNewCar(new Car(new Car.CarBuilder()
                    .setId((long) id)
                    .setBrand(brand)
                    .setModel(model)
                    .setOwner(new Owner(ownerName, ownerGender))
                    .setVinCode(vin)
                    .setPlate(plate)
                    .setEngine(engine))); //building a car object using Builder pattern
            return new ResponseEntity<>("All good, car created", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/car/repairs/{id}")
    public ResponseEntity<?> getCarRepairsById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(carService.getCarById(id).getRepairs(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/car/repairs/register")
    public ResponseEntity<?> registerIssue(@RequestParam Long id, String issue, Long issueId) {
        try {
            repairService.registerNewRepair(carService.getCarById((id)), issue, issueId);
            return new ResponseEntity<>("All good, issue registered", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/car/repairs/resolve/{issueId}")
    public ResponseEntity<?> provideRepair(@PathVariable Long issueId, @RequestParam Long carId, @RequestParam String fix) {
        try {
            repairService.resolveIssue(repairService.getRepairByCarIdAndRepairId(carId, issueId), fix);
            return new ResponseEntity<>("Issue resolved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/")
    public ResponseEntity mainPage() {
        return new ResponseEntity("<h1>Hello and welcome to my car service</h1>", HttpStatus.OK);
    }

    @GetMapping("/decorator")
    public ResponseEntity<?> testDecoratorAndComposite() {
        try {
            Director director = Director.getInstance();
            director.getAdministration()
                    .add(((Administrator) entityFactory.getEntity("administrator")).setName("admin 1"));
            director.getAdministration().get(0).getMechanics().add(((Mechanic) entityFactory.getEntity("mechanic")).setName("mechanic1"));
            Repair testRepair = ((Repair) entityFactory.getEntity("repair")).setId(1L).setIssue("Brake not working");
            director.resolveIssue(testRepair);
            ElectricalDecorator electricalDecorator = new ElectricalDecorator(testRepair);
            electricalDecorator.decorateRepair();

            return new ResponseEntity<>(testRepair.getResolution(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
