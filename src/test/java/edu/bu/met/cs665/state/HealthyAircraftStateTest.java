package edu.bu.met.cs665.state;

import static org.junit.Assert.*;

import edu.bu.met.cs665.Aircraft;
import edu.bu.met.cs665.parts.Engine;
import edu.bu.met.cs665.parts.Radar;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class HealthyAircraftStateTest {

  Aircraft F22;
  LocalDate currentDate = LocalDate.of(2010, Month.JANUARY, 1);

  long id = 1L;
  String modelName = "F-22";

  Radar radar;
  Engine engine;

  int refuelingRate = 1000;
  int speed = 2410;
  int range = 1600;
  int engineThrust = 35000;
  int weight = 38000;

  @Before
  public void setUp() {
    radar = new Radar("electronic span");
    radar.setStartDate(LocalDate.of(2002, Month.JANUARY, 1));
    radar.setLifespan(20);

    engine = new Engine("gas turbine");
    engine.setStartDate(LocalDate.of(2000, Month.JANUARY, 1));
    engine.setLifespan(30);

    F22 = new Aircraft.Builder(id)
        .withModelName(modelName)
        .withDate(currentDate)
        .withRadar(radar)
        .withEngine(engine)
        .withRefuelRate(refuelingRate)
        .withSpeed(speed)
        .withRange(range)
        .withEngineThrust(engineThrust)
        .withWeight(weight)
        .build();
  }

  @Test
  public void getHealthyState() {
    assertEquals("healthy", F22.getStatus());
  }

  @Test
  public void getStateAfterMaintenance() {
    F22.evaluate();
    F22.performMaintenance();
    assertEquals("healthy", F22.getStatus());
  }
}