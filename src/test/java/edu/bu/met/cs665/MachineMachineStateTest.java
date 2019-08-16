package edu.bu.met.cs665;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MachineMachineStateTest {

  BeverageVendingMachine vendingMachine;

  @Before
  public void setUp() {
    vendingMachine = new BeverageVendingMachine();
  }

  @Test
  public void defaultStates() {
    assertFalse(vendingMachine.isInitialized());
    assertFalse(vendingMachine.isReady());
    assertFalse(vendingMachine.isBrewing());
  }

  @Test
  public void getStateSummary() {
    String state = vendingMachine.getMachineState();
    assertTrue(state.equals("Uninitialized"));
  }

  @Test
  public void getStateSummaryAfterInitialization() {
    vendingMachine.initialize();
    String state = vendingMachine.getMachineState();
    assertTrue(state.equals("Ready"));
  }

  @Test
  public void getStateSummaryDuringBrew() {
    vendingMachine.initialize();
    vendingMachine.brew("Americano");
    String state = vendingMachine.getMachineState();
    assertTrue(state.equals("Brewing"));
  }

  @Test
  public void getStateSummaryAfterServe() {
    vendingMachine.initialize();
    vendingMachine.brew("Americano");
    vendingMachine.serve();

    String state = vendingMachine.getMachineState();
    assertTrue(state.equals("Ready"));
  }
}