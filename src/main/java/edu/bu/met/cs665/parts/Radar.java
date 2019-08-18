package edu.bu.met.cs665.parts;

import java.time.LocalDate;

public class Radar extends MaintenanceUtil implements Part {

  private int lifespanYears;
  private LocalDate startDate;

  private int buffer = 2;
  private String name;

  public Radar(String name) {
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

  public String checkHealth(LocalDate date) {
    return checkPartHealth(this, date);
  }

  public int getYearsLeft(LocalDate date) {
    return getPartYearsLeft(this, date);
  }
}
