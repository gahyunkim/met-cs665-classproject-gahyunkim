package edu.bu.met.cs665;

public class Mission {

  private String missionType;

  public Mission(String type) {
    missionType = type;
  }

  public String getType() {
    return missionType;
  }

  public void setType(String type) {
    this.missionType = type;
  }

  public String getDescription() {
    switch(missionType) {
      case "attack":
        return getAttackDescription();
      case "cargo":
        return getCargoDescription();
      case "fighter":
        return getFighterDescription();
      case "observation":
        return getObservationDescription();
      default:
        return missionType;
    }
  }

  private String getAttackDescription() {
    return "Search out, attack, and destroy enemy targets";
  }

  private String getCargoDescription() {
    return "Carry cargo, passengers, and medical patients";
  }

  private String getFighterDescription() {
    return "Intercept and destroy other aircraft and missiles";
  }

  private String getObservationDescription() {
    return "Observe and report tactical information of enemy forces";
  }
}
