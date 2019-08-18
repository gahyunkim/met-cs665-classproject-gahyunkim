package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.parts.Engine;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class EngineHealthTest {

  Engine engine;

  @Before
  public void setUp() {
    engine = new Engine("electronic span");
    engine.setLifespan(10);
    engine.setStartDate(
        LocalDate.of(2000, Month.JANUARY, 1)
    );
  }

  @Test
  public void yearsUntilMaintenance() {
    int yearsRemaining = engine.getYearsLeft(
        LocalDate.of(2008, Month.JANUARY, 1)
    );
    assertEquals(2, yearsRemaining);
  }

  @Test
  public void checkPositiveHealth() {
    String status = engine.checkHealth(
        LocalDate.of(2002, Month.JANUARY, 1)
    );
    assertEquals("healthy", status);
  }

  @Test
  public void checkWarningHealthDefaultBuffer() {
    String status = engine.checkHealth(
        LocalDate.of(2009, Month.JANUARY, 1)
    );
    assertEquals("warning", status);
  }

  @Test
  public void checkWarningHealthCustomBuffer() {
    String originalStatus = engine.checkHealth(
        LocalDate.of(2006, Month.JANUARY, 1)
    );
    assertEquals("healthy", originalStatus);

    engine.setBuffer(5);
    String recheckStatus = engine.checkHealth(
        LocalDate.of(2006, Month.JANUARY, 1)
    );
    assertEquals("warning", recheckStatus);
  }

  @Test
  public void checkCriticalHealth() {
    String status = engine.checkHealth(
        LocalDate.of(2010, Month.JANUARY,1)
    );
    assertEquals("critical", status);

    String overdueStatus = engine.checkHealth(
        LocalDate.of(2011, Month.JANUARY, 1)
    );
    assertEquals("critical", status);
  }
}