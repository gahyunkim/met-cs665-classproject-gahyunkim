package edu.bu.met.cs665.mission;

public class ObservationMission implements MissionType {
  // Objective description for observation mission type
  private String description = "Observe and report tactical information of enemy forces";

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
