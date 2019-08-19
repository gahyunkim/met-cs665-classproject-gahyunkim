package edu.bu.met.cs665;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissionTest {

  @Test
  public void attackMission() {
    Mission attack = new Mission("attack");
    String description = attack.getDescription();
    assertTrue(description.contains("Search out, attack"));
  }

  @Test
  public void cargoMission() {
    Mission attack = new Mission("cargo");
    String description = attack.getDescription();
    assertTrue(description.contains("Carry cargo"));
  }

  @Test
  public void fighterMission() {
    Mission fighter = new Mission("fighter");
    String description = fighter.getDescription();
    assertTrue(description.contains("Intercept and destroy"));
  }

  @Test
  public void observationMission() {
    Mission observer = new Mission("observation");
    String description = observer.getDescription();
    assertTrue(description.contains("Observe and report"));
  }
}