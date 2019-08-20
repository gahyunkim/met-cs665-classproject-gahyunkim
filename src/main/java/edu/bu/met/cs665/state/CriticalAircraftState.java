package edu.bu.met.cs665.state;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.AircraftState;
import edu.bu.met.cs665.Part;
import edu.bu.met.cs665.parts.MaintenanceUtil;
import edu.bu.met.cs665.parts.PartsInventory;
import java.util.List;

public class CriticalAircraftState extends MaintenanceUtil implements AircraftState {
  private Aircraft aircraft;
  private PartsInventory inventory;

  public CriticalAircraftState(Aircraft aircraft) {
    this.aircraft = aircraft;
    this.inventory = aircraft.getInventory();
  }

  public void evaluate() {
    PartsInventory inventory = aircraft.getInventory();
    if (inventory.getStatus().equalsIgnoreCase("healthy")) {
      aircraft.setState(aircraft.getHealthyAircraftState());
      aircraft.evaluate();
      return;
    } else if (inventory.getStatus().equalsIgnoreCase("warning")) {
      aircraft.setState(aircraft.getWarningAircraftState());
      aircraft.evaluate();
      return;
    } else {
      return;
    }
  }

  public void printResults() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("CRITICAL - Please perform maintenance for following:");

    for (Part part: inventory.getCriticalParts()) {
      printMaintenance(part);
    }

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  private void printMaintenance(Part part) {
    System.out.println("Part " + part.getName() + " inspection");
    System.out.print(" due in " + inventory.getYearsLeft(part));
  }

  public void performMaintenance() {
    List<Part> partList = aircraft.getInventory().getParts();
    for (Part part : partList) {
      performPartMaintenance(part, aircraft.getDate());
    }
    aircraft.setState(aircraft.getHealthyAircraftState());
    System.out.println("\nMaintenance complete!\n");
  }

  public String get() {
    return "critical";
  }
}
