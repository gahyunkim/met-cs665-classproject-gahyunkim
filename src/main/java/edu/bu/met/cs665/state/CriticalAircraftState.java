package edu.bu.met.cs665.state;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.AircraftState;
import edu.bu.met.cs665.Part;
import edu.bu.met.cs665.parts.MaintenanceUtil;
import edu.bu.met.cs665.parts.PartsInventory;
import java.util.List;

public class CriticalAircraftState extends MaintenanceUtil implements AircraftState {
  private Aircraft aircraft;
  private List<Part> criticalParts;
  private PartsInventory inventory;

  public CriticalAircraftState(Aircraft aircraft) {
    this.aircraft = aircraft;
    this.inventory = aircraft.getInventory();
  }

  // Assesses and changes state appropriately based on critical/warning/healthy status
  // If status is same, retrieves critical parts needing maintenance
  public void evaluate() {
    PartsInventory inventory = aircraft.getInventory();
    if (inventory.getStatus().equalsIgnoreCase("healthy")) {
      aircraft.setState(aircraft.getHealthyAircraftState());
      aircraft.checkHealth();
      return;
    } else if (inventory.getStatus().equalsIgnoreCase("warning")) {
      aircraft.setState(aircraft.getWarningAircraftState());
      aircraft.checkHealth();
      return;
    } else {
      criticalParts = inventory.getCriticalParts();
      return;
    }
  }

  // Prints critical parts needing immediate attention
  public void printResults() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("CRITICAL - Please perform maintenance for following:");
    for (Part part: criticalParts) {
      printMaintenance(part);
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  // Prints part and years left until required maintenance
  private void printMaintenance(Part part) {
    System.out.println("Part " + part.getName() + " inspection");
    System.out.print(" due in " + inventory.getYearsLeft(part));
  }

  // Performs immediate maintenance on critical parts
  public void performMaintenance() {
    List<Part> criticalParts = aircraft.getInventory().getCriticalParts();
    for (Part part : criticalParts) {
      performPartMaintenance(part, aircraft.getDate());
    }
    aircraft.setState(aircraft.getHealthyAircraftState());
    System.out.println("\nMaintenance complete!\n");
  }

  // Retrieves critical status name
  public String get() {
    return "critical";
  }
}
