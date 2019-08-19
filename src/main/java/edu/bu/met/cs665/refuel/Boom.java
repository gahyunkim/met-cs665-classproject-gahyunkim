package edu.bu.met.cs665.refuel;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.RefuelMethod;

public class Boom implements RefuelMethod {

  public void refuel(Aircraft aircraft) {
    System.out.println("Operator navigating boom");
    System.out.println("Boom latched in position");
    System.out.println("Extending boom");

    System.out.println("Refueling at: " + aircraft.getRefuelingRate()
        + "pounds per minute");

    System.out.println("Refuel complete!");
  }

  public String getName() {
    return "Boom";
  }

}
