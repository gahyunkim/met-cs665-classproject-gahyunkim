package edu.bu.met.cs665.parts;

import edu.bu.met.cs665.Part;
import java.time.LocalDate;

public class Engine extends MaintenanceUtil implements Part {

  private String name;

  // Date which part's use was installed and initiated
  private LocalDate startDate;
  // Number of years part is expected to last until required maintenance
  private int lifespanYears;
  // Number of years until required maintenance that warning message will be triggered
  private int buffer = 2;

  public Engine(String name) {
    this.name = name;
  }

  public void setLifespan(int years) {
    this.lifespanYears = years;
  }

  public int getLifespan() {
    return lifespanYears;
  }

  public void setStartDate(LocalDate date) {
    this.startDate = date;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setBuffer(int buffer) {
    this.buffer = buffer;
  }

  public int getBuffer() {
    return buffer;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // Given current date, checks part using MaintenanceUtil te get healthy/warning/critical status
  public String checkHealth(LocalDate date) {
    return checkPartHealth(this, date);
  }

  // Returns years left until required maintenance
  public int getYearsLeft(LocalDate date) {
    return getPartYearsLeft(this, date);
  }
}
