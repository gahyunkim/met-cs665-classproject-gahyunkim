package edu.bu.met.cs665.state;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.AircraftState;
import edu.bu.met.cs665.Part;
import edu.bu.met.cs665.parts.MaintenanceUtil;
import edu.bu.met.cs665.parts.PartsInventory;

public class HealthyAircraftState extends MaintenanceUtil implements AircraftState {
  private Aircraft aircraft;
  private Part immediatePart;
  private int yearsLeft;

  public HealthyAircraftState(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  // Assesses and changes state appropriately based on critical/warning/healthy status
  // If status is same, gets part with least amount of years left until required maintenance
  public void evaluate() {
    PartsInventory inventory = aircraft.getInventory();
    if (inventory.getStatus().equals("critical")) {
      aircraft.setState(aircraft.getCriticalAircraftState());
      aircraft.checkHealth();
      return;
    } else if (inventory.getStatus().equals("warning")) {
      aircraft.setState(aircraft.getWarningAircraftState());
      aircraft.checkHealth();
      return;
    } else {
      immediatePart = inventory.getImmedateMaintenancePart();
      yearsLeft = inventory.getYearsLeft(immediatePart);
      return;
    }
  }

  // Prints positive result and part that needs the soonest maintenance
  public void printResults() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Aircraft is in good condition.");
    System.out.println("Ready for flight!");
    System.out.println("----------------------------");
    System.out.println("Next maintenance for " + immediatePart.getName());
    System.out.println("needed in " + yearsLeft + "years");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  // Performs maintenance on part with closest maintenance date
  public void performMaintenance() {
    performPartMaintenance(immediatePart, aircraft.getDate());
    System.out.println("\nMaintenance complete!\n");
  }

  public String get() {
    return "healthy";
  }
}
