package edu.bu.met.cs665.parts;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

public class PartsInventoryTest {

  @Test
  public void singlePartInventory() {
    Part engine = new Engine("Pratt & Whitney");
    engine.setLifespan(5);
    engine.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    PartsInventory inventory = new PartsInventory(
        LocalDate.of(2010, Month.APRIL, 1)
    );
    inventory.add(engine);

    assertEquals(1, inventory.getSize());
    assertEquals(engine, inventory.getPartNeedingMaintenance());
  }
}