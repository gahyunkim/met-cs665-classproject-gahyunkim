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

    final long id = 1L;
    final String modelName = "F-22";
    final LocalDate currentDate = LocalDate.of(2010, Month.APRIL, 1);

    Radar radar = new Radar("electronic span");
    Engine engine = new Engine("gas turbine");

    final int refuelingRate = 1000;
    final int speed = 2410;
    final int range = 1600;
    final int engineThrust = 35000;
    final int weight = 38000;

    radar.setLifespan(10);
    radar.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    engine.setLifespan(15);
    engine.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    Aircraft raptor = new Aircraft.Builder(id)
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

    raptor.printSpecs();
    raptor.getInventory().print();

    raptor.printStatus();
    raptor.performMaintenance();
    raptor.printStatus();


    raptor.refuel();
    raptor.setRefuelMethod(new Boom());
    raptor.refuel();


    NavalAviator george = new NavalAviator("Lieutenant Young");
    AirForcePilot mike = new AirForcePilot("Captain Byon");
    raptor.addPilot(george);
    raptor.addPilot(mike);

    raptor.setMission(new Mission("fighter"));
    raptor.notifyPilots();
  }
}