package edu.bu.met.cs665.mission;

public class AttackMission implements MissionType {
  private String description = "Search out, attack, and destroy enemy targets";

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
