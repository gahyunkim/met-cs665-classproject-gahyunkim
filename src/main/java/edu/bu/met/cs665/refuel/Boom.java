package edu.bu.met.cs665.refuel;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.RefuelMethod;

public class Boom implements RefuelMethod {

  // Executes aerial refueling using boom method
  public void refuel(Aircraft aircraft) {
    System.out.println("\t> Operator navigating boom");
    System.out.println("\t> Boom latched in position");
    System.out.println("\t> Extending boom");

    System.out.println("\t> Refueling at: " + aircraft.getRefuelingRate()
        + "pounds per minute");

    System.out.println("Refuel complete!");
  }

  public String getName() {
    return "Boom";
  }

}
