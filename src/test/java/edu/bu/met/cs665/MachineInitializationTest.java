package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MachineInitializationTest {
  BeverageVendingMachine beverageVendingMachine;
  @Before
  public void initialize() {
    beverageVendingMachine = new BeverageVendingMachine();
  }

  @Test
  public void defaultBeveragePrices() {
    assertEquals(0, beverageVendingMachine.getBeveragePrice("Green Tea"));
    assertEquals(0, beverageVendingMachine.getBeveragePrice("Latte Macchiato"));
  }

  @Test
  public void setBeveragePrices() {
    beverageVendingMachine.setBeveragePrice("Espresso", 1);
    assertEquals(1, beverageVendingMachine.getBeveragePrice("Espresso"));
  }

  @Test
  public void initializeWithoutPrices() {
    beverageVendingMachine.initialize();
    assertFalse(beverageVendingMachine.isInitialized());
  }

  @Test
  public void initializeWithSomePrices() {
    beverageVendingMachine.setBeveragePrice("Americano", 1);
    beverageVendingMachine.setBeveragePrice("Black Tea", 2);
    beverageVendingMachine.setBeveragePrice("Yellow Tea", 2);
    beverageVendingMachine.initialize();
    assertFalse(beverageVendingMachine.isInitialized());
  }

  @Test
  public void initializeWithAllPrices() {
    beverageVendingMachine.setBeveragePrice("Americano", 1);
    beverageVendingMachine.setBeveragePrice("Espresso", 3);
    beverageVendingMachine.setBeveragePrice("Latte Macchiato", 1);
    beverageVendingMachine.setBeveragePrice("Black Tea", 2);
    beverageVendingMachine.setBeveragePrice("Yellow Tea", 2);
    beverageVendingMachine.setBeveragePrice("Green Tea", 1);
    beverageVendingMachine.initialize();
    assertTrue(beverageVendingMachine.isInitialized());
  }

  @Test
  public void brewWithoutInitializing() {
    beverageVendingMachine.brew("Latte Macchiato");
    assertFalse(beverageVendingMachine.isBrewing());
  }
}