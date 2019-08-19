package edu.bu.met.cs665.refuel;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.RefuelMethod;

public class Drogue implements RefuelMethod {

  public void refuel(Aircraft aircraft) {
    System.out.println("\t> Operator extending drogue basket");
    System.out.println("\t> Drogue fully extended");
    System.out.println("\t> Probe latched");

    System.out.println("\t> Refueling at: " + aircraft.getRefuelingRate()
        + "pounds per minute");

    System.out.println("Refuel complete!");
  }

  public String getName() {
    return "Drogue";
  }
}
