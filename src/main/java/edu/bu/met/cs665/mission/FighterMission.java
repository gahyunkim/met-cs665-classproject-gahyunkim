package edu.bu.met.cs665.mission;

public class FighterMission implements MissionType {
  // Objective description for fighter mission type
  private String description = "Intercept and destroy other aircraft and missiles";

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
