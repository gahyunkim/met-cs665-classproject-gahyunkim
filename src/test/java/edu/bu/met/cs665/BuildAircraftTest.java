package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.parts.Engine;
import edu.bu.met.cs665.parts.PartsInventory;
import edu.bu.met.cs665.parts.Radar;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

public class BuildAircraftTest {

  @Test
  public void buildAircraft() {
    long id = 1L;
    String modelName = "F-22";

    Radar radar = new Radar("electronic span");
    radar.setStartDate(LocalDate.of(2002, Month.JANUARY, 1));
    radar.setLifespan(20);

    Engine engine = new Engine("gas turbine");
    engine.setStartDate(LocalDate.of(2000, Month.JANUARY, 1));
    engine.setLifespan(10);

    int refuelingRate = 1000;
    int speed = 2410;
    int range = 1600;
    int engineThrust = 35000;
    int weight = 38000;

    Aircraft F22 = new Aircraft.Builder(id)
        .withModelName(modelName)
        .withDate(LocalDate.now())
        .withRadar(radar)
        .withEngine(engine)
        .withRefuelRate(refuelingRate)
        .withSpeed(speed)
        .withRange(range)
        .withEngineThrust(engineThrust)
        .withWeight(weight)
        .build();

    assertEquals(id, F22.getId());
    assertEquals(modelName, F22.getModelName());

    PartsInventory inventory = F22.getInventory();
    assertEquals(2, inventory.getSize());
    assertTrue(inventory.contains(engine));
    assertTrue(inventory.contains(radar));

    assertEquals(refuelingRate, F22.getRefuelingRate());
    assertEquals(speed, F22.getSpeed());
    assertEquals(range, F22.getRange());
    assertEquals(engineThrust, F22.getEngineThrust());
    assertEquals(weight, F22.getWeight());
  }

}