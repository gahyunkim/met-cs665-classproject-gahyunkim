package edu.bu.met.cs665;

import edu.bu.met.cs665.mission.AttackMission;
import edu.bu.met.cs665.mission.CargoMission;
import edu.bu.met.cs665.mission.FighterMission;
import edu.bu.met.cs665.mission.MissionType;
import edu.bu.met.cs665.mission.ObservationMission;

public class Mission {

  private MissionType type;
  private String typeName;
  private String takeoffBase;
  private String landingBase;

  public Mission(String typeName) {
    switch (typeName) {
      case "attack":
        type = new AttackMission();
        return;
      case "cargo":
        type = new CargoMission();
        return;
      case "fighter":
        type = new FighterMission();
        return;
      case "observation":
        type = new ObservationMission();
        return;
      default:
        return;
    }
  }

  public void setTakeoffBase(String baseIcao) {
    this.takeoffBase = baseIcao;
  }

  public String getTakeoffBase() {
    return takeoffBase;
  }

  public void setLandingBase(String baseIcao) {
    this.landingBase = baseIcao;
  }

  public String getLandingBase() {
    return landingBase;
  }

  public MissionType getType() {
    return type;
  }

  public void setType(MissionType type) {
    this.type = type;
  }

  public String getTypeName() {
    return typeName;
  }

  public String getDescription() {
    return type.getDescription()
        + "\n\t\t\t\tTakeoff Base: " + takeoffBase
        + "\n\t\t\t\tLanding Base: " + landingBase;
  }
}
