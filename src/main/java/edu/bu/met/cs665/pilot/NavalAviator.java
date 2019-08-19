package edu.bu.met.cs665.pilot;

import edu.bu.met.cs665.Mission;
import edu.bu.met.cs665.Pilot;

public class NavalAviator implements Pilot {
  private String type = "Navy";
  private String name;
  private Mission mission;

  public NavalAviator(String name) {
    this.name = name;
  }

  public void update(Mission mission) {
    System.out.println("\t> Naval Aviator " + name + " received " + mission.getType() + " mission.");
    System.out.println("\t\t\tObjective: " + mission.getDescription());
    setMission(mission);
  }

  public Mission getMission() {
    return mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
}
