package edu.bu.met.cs665.refuel;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.RefuelMethod;

public class Drogue implements RefuelMethod {
  private Aircraft aircraft;

  public void refuel(Aircraft aircraft) {
    System.out.println("Operator extending drogue basket");
    System.out.println("Drogue fully extended");
    System.out.println("Probe latched");

    System.out.println("Refueling at: " + aircraft.getRefuelingRate() +
        "pounds per minute");

    System.out.println("Refuel complete!");
  }

  public String getName() {
    return "Drogue";
  }
}
