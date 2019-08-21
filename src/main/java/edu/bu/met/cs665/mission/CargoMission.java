package edu.bu.met.cs665.mission;

public class CargoMission implements MissionType {
  // Objective description for cargo mission type
  private String description = "Carry cargo, passengers, and medical patients";

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
