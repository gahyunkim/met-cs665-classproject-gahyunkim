package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.pilot.AirForcePilot;
import edu.bu.met.cs665.pilot.NavalAviator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MissionNotificationTest extends SampleAircraft {

  NavalAviator jonathan = new NavalAviator("Captain Ahn");
  AirForcePilot susie = new AirForcePilot("Lieutenant Kim");
  Aircraft F22 = buildF22();

  @Before
  public void setUp() {
    F22.addPilot(jonathan);
    F22.addPilot(susie);
  }

  @Test
  public void notifyPilots() {
    assertEquals(null, jonathan.getMission());
    assertEquals(null, susie.getMission());

    Mission mission = new Mission("fighter");
    mission.setTakeoffBase("Hartsfield International Airport");
    mission.setLandingBase("Logan International Airport");
    F22.setMission(mission);
    F22.notifyPilots();

    assertEquals(mission, jonathan.getMission());
    assertEquals(mission, susie.getMission());
  }

  @Test
  public void addingPilots() {
    List<Pilot> pilotList = F22.getPilots();

    assertEquals(2, pilotList.size());
    assertTrue(pilotList.contains(susie));
    assertTrue(pilotList.contains(jonathan));
  }

  @Test
  public void removePilots() {
    F22.removePilot(jonathan);
    List<Pilot> pilotList = F22.getPilots();

    assertEquals(1, pilotList.size());
    assertTrue(pilotList.contains(susie));
    assertFalse(pilotList.contains(jonathan));
  }
}