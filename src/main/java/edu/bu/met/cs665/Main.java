package edu.bu.met.cs665;

import edu.bu.met.cs665.parts.Engine;
import edu.bu.met.cs665.parts.Radar;
import edu.bu.met.cs665.pilot.AirForcePilot;
import edu.bu.met.cs665.pilot.NavalAviator;
import edu.bu.met.cs665.refuel.Boom;
import java.time.LocalDate;
import java.time.Month;

public class Main {

  public static void main(String[] args) {

    long id = 1L;
    String modelName = "F-22";
    LocalDate currentDate = LocalDate.of(2010, Month.APRIL, 1);

    Radar radar = new Radar("electronic span");
    Engine engine = new Engine("gas turbine");

    int refuelingRate = 1000;
    int speed = 2410;
    int range = 1600;
    int engineThrust = 35000;
    int weight = 38000;

    radar.setLifespan(10);
    radar.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    engine.setLifespan(15);
    engine.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    Aircraft F22 = new Aircraft.Builder(id)
        .withModelName(modelName)
        .withDate(currentDate)
        .withRadar(radar)
        .withEngine(engine)
        .withRefuelRate(refuelingRate)
        .withSpeed(speed)
        .withRange(range)
        .withEngineThrust(engineThrust)
        .withWeight(weight)
        .build();

    F22.printSpecs();
    F22.getInventory().print();

    F22.printStatus();
    F22.performMaintenance();
    F22.printStatus();



    F22.refuel();
    F22.setRefuelMethod(new Boom());
    F22.refuel();


    NavalAviator george = new NavalAviator("Lieutenant Young");
    AirForcePilot mike = new AirForcePilot("Captain Byon");
    F22.addPilot(george);
    F22.addPilot(mike);

    F22.setMission(new Mission("fighter"));
    F22.notifyPilots();
  }
}