package edu.bu.met.cs665.state;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.AircraftState;
import edu.bu.met.cs665.Part;
import edu.bu.met.cs665.parts.MaintenanceUtil;
import edu.bu.met.cs665.parts.PartsInventory;
import java.util.List;

public class HealthyAircraftState extends MaintenanceUtil implements AircraftState {
  private Aircraft aircraft;
  private String partName;
  private int yearsLeft;

  public HealthyAircraftState(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public void evaluate() {
    PartsInventory inventory = aircraft.getInventory();
    if (inventory.getStatus().equals("critical")) {
      aircraft.setState(aircraft.getCriticalAircraftState());
      aircraft.evaluate();
      return;
    } else if (inventory.getStatus().equals("warning")) {
      aircraft.setState(aircraft.getWarningAircraftState());
      aircraft.evaluate();
      return;
    } else {
      Part part = inventory.getImmedateMaintenancePart();
      partName = part.getName();
      yearsLeft = inventory.getYearsLeft(part);
      return;
    }
  }

  public void printResults() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Aircraft is in good condition.");
    System.out.println("Ready for flight!");
    System.out.println("----------------------------");
    System.out.println("Next maintenance for " + partName);
    System.out.println("needed in " + yearsLeft + "years");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public void performMaintenance() {
    List<Part> partList = aircraft.getInventory().getParts();
    for (Part part : partList) {
      performPartMaintenance(part, aircraft.getDate());
    }
    System.out.println("\nMaintenance complete!\n");
  }

  public String get() {
    return "healthy";
  }
}
