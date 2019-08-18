package edu.bu.met.cs665.parts;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class PartsInventoryTest {

  Part engine;
  Part radar;

  PartsInventory inventory;
  LocalDate date;

  @Before
  public void setUp() throws Exception {
    engine = new Engine("Pratt & Whitney");
    engine.setLifespan(5);
    engine.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    radar = new Radar("LLLR");
    radar.setLifespan(10);
    radar.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    date = LocalDate.of(2002, Month.APRIL, 1);
    inventory = new PartsInventory(date);
  }

  @Test
  public void singlePartInventory() {
    inventory.add(radar);
    assertEquals(1, inventory.getSize());
    assertEquals(radar, inventory.getCriticalMaintenancePart());
    assertEquals(8, inventory.getYearsLeft(radar));
  }

  @Test
  public void multiplePartsInventory() {
    inventory.add(radar);
    inventory.add(engine);
    assertEquals(2, inventory.getSize());
    assertEquals(engine, inventory.getCriticalMaintenancePart());
    assertEquals(3, inventory.getYearsLeft(engine));
  }
}