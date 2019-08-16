package edu.bu.met.cs665;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MachineBrewTest {

  BeverageVendingMachine beverageVendingMachine;

  @Before
  public void setUp() {
    beverageVendingMachine = new BeverageVendingMachine();
  }

  @Test
  public void brewWithoutInitializing() {
    beverageVendingMachine.brew("Latte Macchiato");
    assertFalse(beverageVendingMachine.isBrewing());
  }

  @Test
  public void brewBeverage() {
    beverageVendingMachine.initialize();
    beverageVendingMachine.brew("Americano");
    assertTrue(beverageVendingMachine.isBrewing());
    assertFalse(beverageVendingMachine.isReady());
  }

  @Test
  public void serveBeverage() {
    beverageVendingMachine.initialize();
    beverageVendingMachine.brew("Espresso");
    beverageVendingMachine.serve();
    assertFalse(beverageVendingMachine.isBrewing());
    assertTrue(beverageVendingMachine.isReady());
  }
}