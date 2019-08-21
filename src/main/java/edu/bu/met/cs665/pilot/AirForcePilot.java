package edu.bu.met.cs665.pilot;

import edu.bu.met.cs665.Mission;
import edu.bu.met.cs665.Pilot;

public class AirForcePilot implements Pilot {
  private String type = "Air Force";
  private String name;
  private Mission mission;

  public AirForcePilot(String name) {
    this.name = name;
  }

  // When receiving mission, Air Force pilot receives its info and is assigned to it
  public void update(Mission mission) {
    System.out.println("\t> Air Force Pilot " + name + " received "
        + mission.getTypeName() + " mission.");
    System.out.println("\t\t\tObjective: " + mission.getDescription());
    setMission(mission);
  }

  public Mission getMission() {
    return mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
}
