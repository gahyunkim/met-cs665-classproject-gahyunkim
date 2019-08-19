package edu.bu.met.cs665;

import edu.bu.met.cs665.parts.Engine;
import edu.bu.met.cs665.parts.PartsInventory;
import edu.bu.met.cs665.parts.Radar;
import edu.bu.met.cs665.refuel.Drogue;
import edu.bu.met.cs665.state.CriticalAircraftState;
import edu.bu.met.cs665.state.HealthyAircraftState;
import edu.bu.met.cs665.state.WarningAircraftState;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aircraft {

  public static class Builder {

    private String modelName;
    private long id;

    private LocalDate date;

    private Engine engine;
    private Radar radar;

    private int refuelingRate;
    private int speed;
    private int range;
    private int engineThrust;
    private int weight;

    public Builder(long id) {
      this.id = id;
    }

    public Builder withModelName(String modelName) {
      this.modelName = modelName;
      return this;
    }

    public Builder withRadar(Radar radar) {
      this.radar = radar;
      return this;
    }

    public Builder withDate(LocalDate date) {
      this.date = date;
      return this;
    }

    public Builder withEngine(Engine engine) {
      this.engine = engine;
      return this;
    }

    public Builder withSpeed(int speed) {
      this.speed = speed;
      return this;
    }

    public Builder withRange(int range) {
      this.range = range;
      return this;
    }

    public Builder withWeight(int weight) {
      this.weight = weight;
      return this;
    }

    public Builder withEngineThrust(int engineThrust) {
      this.engineThrust = engineThrust;
      return this;
    }

    public Builder withRefuelRate(int refuelingRate) {
      this.refuelingRate = refuelingRate;
      return this;
    }

    public Aircraft build() {
      Aircraft aircraft = new Aircraft();

      aircraft.setModelName(modelName);
      aircraft.setId(id);
      aircraft.setDate(date);
      aircraft.setRadar(radar);
      aircraft.setEngine(engine);
      aircraft.setRefuelingRate(refuelingRate);
      aircraft.setSpeed(speed);
      aircraft.setRange(range);
      aircraft.setEngineThrust(engineThrust);
      aircraft.setWeight(weight);

      aircraft.evaluate();

      return aircraft;
    }
  }

  private LocalDate date = LocalDate.now();

  private String modelName;
  private long id;

  private PartsInventory inventory;

  private RefuelMethod refuelMethod;
  private int refuelingRate;

  private int speed;
  private int range;
  private int engineThrust;
  private int weight;

  HealthyAircraftState healthyAircraftState;
  WarningAircraftState warningAircraftState;
  CriticalAircraftState criticalAircraftState;

  AircraftState state;

  Mission mission;
  List<Pilot> pilotList;

  private Aircraft() {
    inventory = new PartsInventory(date);
    healthyAircraftState = new HealthyAircraftState(this);
    warningAircraftState = new WarningAircraftState(this);
    criticalAircraftState = new CriticalAircraftState(this);
    state = healthyAircraftState;
    pilotList = new ArrayList<>();
    refuelMethod = new Drogue();
  }

  public void setMission(Mission mission) {
    System.out.println("\n////////////////////////////////////");
    System.out.println("* Tasked " + modelName + " with "
        + mission.getType().toUpperCase() + " mission *");
    System.out.println("////////////////////////////////////\n");
    this.mission = mission;
  }

  public Mission getMission() {
    return mission;
  }

  public void notifyPilots() {
    if (mission == null) {
      System.out.println("Currently no tasked mission");
    }
    System.out.println("COMM squadron notifying pilots . . .");
    Collections.shuffle(pilotList);
    for (Pilot pilot : pilotList) {
      pilot.update(mission);
    }
  }

  public void addPilot(Pilot pilot) {
    pilotList.add(pilot);
  }

  public void removePilot(Pilot pilot) {
    pilotList.remove(pilot);
  }

  public List<Pilot> getPilots() {
    return pilotList;
  }

  public void refuel() {
    System.out.println("\nStarting " + refuelMethod.getName() + " refueling process:");
    refuelMethod.refuel(this);
  }

  public void setRefuelMethod(RefuelMethod method) {
    this.refuelMethod = method;
  }

  public RefuelMethod getRefuelMethod() {
    return refuelMethod;
  }

  public void evaluate() {
    state.evaluate();
  }

  public void printResults() {
    state.printResults();
  }

  public void performMaintenance() {
    System.out.println("Starting maintenance");
    state.performMaintenance();
  }

  public String getStatus() {
    return state.get();
  }

  public void setDate(LocalDate date) {
    this.date = date;
    inventory.setDate(date);
  }

  public LocalDate getDate() {
    return date;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getModelName() {
    return modelName;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setRadar(Radar radar) {
    inventory.add(radar);
    state.evaluate();
  }

  public void setEngine(Engine engine) {
    inventory.add(engine);
    state.evaluate();
  }

  public void addPart(Part part) {
    inventory.add(part);
    state.evaluate();
  }

  public void setEngineThrust(int engineThrust) {
    this.engineThrust = engineThrust;
  }

  public int getEngineThrust() {
    return this.engineThrust;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public void setRefuelingRate(int refuelingRate) {
    this.refuelingRate = refuelingRate;
  }

  public int getRefuelingRate() {
    return refuelingRate;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  public void setRange(int range) {
    this.range = range;
  }

  public int getRange() {
    return range;
  }

  public void setState(AircraftState state) {
    this.state = state;
  }

  public AircraftState getState() {
    return state;
  }

  public HealthyAircraftState getHealthyAircraftState() {
    return healthyAircraftState;
  }

  public WarningAircraftState getWarningAircraftState() {
    return warningAircraftState;
  }

  public CriticalAircraftState getCriticalAircraftState() {
    return criticalAircraftState;
  }

  public PartsInventory getInventory() {
    return inventory;
  }

  public void printSpecs() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("| Aircraft Model: " + modelName);
    System.out.println("| ID: " + id);

    printParts();

    System.out.println("| Refueling Rate: " + refuelingRate + " lb/min");
    System.out.println("| Speed: " + speed + " km/h");
    System.out.println("| Range: " + range + " km");
    System.out.println("| Engine Thrust: " + engineThrust + " lb");
    System.out.println("| Weight: " + weight + " lb");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public void printParts() {
    System.out.println("| PARTS: ");
    for (Part part: inventory.getParts()) {
      System.out.println("|    " + part.getName());
    }
  }

  public void printStatus() {
    System.out.println("**********************************");
    System.out.println("* " + modelName + " id: #" + id + " - STATUS: " + getStatus().toUpperCase());
    System.out.println("**********************************\n");
  }
}