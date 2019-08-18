package edu.bu.met.cs665.states;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.parts.Part;
import edu.bu.met.cs665.parts.MaintenanceUtil;
import edu.bu.met.cs665.parts.PartsInventory;

public class HealthyAircraftState implements AircraftState{
  private Aircraft aircraft;

  public HealthyAircraftState(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public void evaluate() {

  }

  public void printResults() {

  }

  public void performMaintenance() {

  }

}
