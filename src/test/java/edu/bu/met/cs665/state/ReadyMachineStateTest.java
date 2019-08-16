package edu.bu.met.cs665.state;

import static org.junit.Assert.*;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;
import org.junit.Test;

public class ReadyMachineStateTest {

  @Test
  public void setBrewingBeverage() {
    BeverageVendingMachine vendingMachine = new BeverageVendingMachine();
    ReadyMachineState readyMachineState = new ReadyMachineState(vendingMachine);
    readyMachineState.brew("Espresso");
    Beverage expectedBeverage = vendingMachine.getBeverage("Espresso");
    assertEquals(expectedBeverage, vendingMachine.getBeverageBrewing());
  }
}