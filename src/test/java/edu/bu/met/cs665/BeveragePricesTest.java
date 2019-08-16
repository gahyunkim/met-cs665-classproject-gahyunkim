package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BeveragePricesTest {
  BeverageVendingMachine beverageVendingMachine;
  @Before
  public void initialize() {
    beverageVendingMachine = new BeverageVendingMachine();
  }

  @Test
  public void defaultBeveragePrices() {
    beverageVendingMachine.setDefaultPrice(3);
    beverageVendingMachine.initialize();
    assertEquals(3, beverageVendingMachine.getBeveragePrice("Green Tea"));
    assertEquals(3, beverageVendingMachine.getBeveragePrice("Latte Macchiato"));
  }

  @Test
  public void setBeveragePrices() {
    beverageVendingMachine.initialize();
    beverageVendingMachine.setBeveragePrice("Espresso", 1);
    assertEquals(1, beverageVendingMachine.getBeveragePrice("Espresso"));
  }
}