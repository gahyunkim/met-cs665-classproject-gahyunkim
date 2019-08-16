package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MachineStateTest {

  BeverageVendingMachine beverageVendingMachine;

  @Before
  public void setUp() {
    beverageVendingMachine = new BeverageVendingMachine();
  }

  @Test
  public void defaultStates() {
    assertFalse(beverageVendingMachine.isInitialized());
    assertFalse(beverageVendingMachine.isReady());
    assertFalse(beverageVendingMachine.isBrewing());
  }

  @Test
  public void getStateSummary() {
    String stateSummary = beverageVendingMachine.getStateSummary();
    assertTrue(stateSummary.contains("uninitialized"));
    assertFalse(stateSummary.contains("brewing"));
  }

  @Test
  public void getStateSummaryAfterInitialization() {
    initializeMachine();

    String stateSummary = beverageVendingMachine.getStateSummary();
    assertTrue(stateSummary.contains("initialized"));
    assertTrue(stateSummary.contains("ready"));
    assertFalse(stateSummary.contains("not ready"));
    assertFalse(stateSummary.contains("brewing"));
  }

  @Test
  public void getStateSummaryDuringBrew() {
    initializeMachine();
    beverageVendingMachine.brew("Americano");

    String stateSummary = beverageVendingMachine.getStateSummary();
    assertTrue(stateSummary.contains("initialized"));
    assertTrue(stateSummary.contains("brewing"));
    assertTrue(stateSummary.contains("not ready"));
  }

  @Test
  public void getStateSummaryAfterServe() {
    initializeMachine();
    beverageVendingMachine.brew("Americano");
    beverageVendingMachine.serve();

    String stateSummary = beverageVendingMachine.getStateSummary();
    assertTrue(stateSummary.contains("initialized"));
    assertTrue(stateSummary.contains("ready"));
    assertFalse(stateSummary.contains("not ready"));
    assertFalse(stateSummary.contains("brewing"));
  }

  @Test
  public void initialStateEqualsAfterBrewState() {
    initializeMachine();
    boolean startingInitialized = beverageVendingMachine.isInitialized();
    boolean startingReady = beverageVendingMachine.isReady();
    boolean startingBrewing = beverageVendingMachine.isBrewing();

    beverageVendingMachine.brew("Green Tea");
    beverageVendingMachine.serve();

    assertEquals(startingInitialized, beverageVendingMachine.isInitialized());
    assertEquals(startingReady, beverageVendingMachine.isReady());
    assertEquals(startingBrewing, beverageVendingMachine.isBrewing());
  }

  private void initializeMachine() {
    beverageVendingMachine.setBeveragePrice("Americano", 1);
    beverageVendingMachine.setBeveragePrice("Espresso", 3);
    beverageVendingMachine.setBeveragePrice("Latte Macchiato", 1);
    beverageVendingMachine.setBeveragePrice("Black Tea", 2);
    beverageVendingMachine.setBeveragePrice("Yellow Tea", 2);
    beverageVendingMachine.setBeveragePrice("Green Tea", 1);
    beverageVendingMachine.initialize();
  }
}