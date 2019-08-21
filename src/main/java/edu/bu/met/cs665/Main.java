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

    // Defining aircraft specifications
    final long id = 1L;
    final String modelName = "F-22";
    final LocalDate currentDate = LocalDate.of(2010, Month.APRIL, 1);
    final int refuelingRate = 1000;
    final int speed = 2410;
    final int range = 1600;
    final int engineThrust = 35000;
    final int weight = 38000;

    // Defining required engine and radar parts
    Radar radar = new Radar("electronic span");
    radar.setLifespan(10);
    radar.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    Engine engine = new Engine("gas turbine");
    engine.setLifespan(15);
    engine.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    /********************
     * BUILDER W/ SPECS *
     ********************/
    // Building raptor aircraft with specifications and parts
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

    // Printing specs and parts inventory
    raptor.printSpecs();
    raptor.getInventory().print();


    /***************
     * MAINTENANCE *
     ***************/
    // Printing aircraft health status, performing maintenance, and checking new status
    raptor.printStatus();
    raptor.performMaintenance();
    raptor.printStatus();


    /*************
     * REFUELING *
     *************/
    // Refuel aircraft using default drogue method, changing it with boom, and refueling again
    raptor.refuel();
    raptor.setRefuelMethod(new Boom());
    raptor.refuel();


    /**********************************
     * MISSION TASKING & NOTIFICATION *
     **********************************/
    // Adding pilots assigned to raptor who will be subscribed to mission notifications
    NavalAviator george = new NavalAviator("Lieutenant Young");
    AirForcePilot mike = new AirForcePilot("Captain Byon");
    raptor.addPilot(george);
    raptor.addPilot(mike);

    // Creating mission type with base details
    Mission fighterMission = new Mission("observation");
    fighterMission.setTakeoffBase("Logan International Airport");
    fighterMission.setLandingBase("Hartsfield-Jackson Atlanta International Airport");

    // Tasking aircraft with mission and notifying assigned pilots
    raptor.setMission(fighterMission);
    raptor.notifyPilots();
  }
}