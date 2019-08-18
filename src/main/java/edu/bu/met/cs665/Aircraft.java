package edu.bu.met.cs665;

import edu.bu.met.cs665.parts.Engine;
import edu.bu.met.cs665.parts.Part;
import edu.bu.met.cs665.parts.PartsInventory;
import edu.bu.met.cs665.parts.Radar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.taskdefs.Local;

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

      return aircraft;
    }
  }

  private LocalDate date = LocalDate.now();

  private String modelName;
  private long id;

  private PartsInventory inventory;

  private int refuelingRate;
  private int speed;
  private int range;
  private int engineThrust;
  private int weight;

  private Aircraft() {
    inventory = new PartsInventory(date);
  }

  public void setDate(LocalDate date) {
    this.date = date;
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
  }

  public void setEngine(Engine engine) {
    inventory.add(engine);
  }

//  public List<Part> getPartsList() {
//    return inventory;
//  }

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

  public PartsInventory getInventory() {
    return inventory;
  }
}
