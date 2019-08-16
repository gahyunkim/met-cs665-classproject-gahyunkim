package edu.bu.met.cs665.state;

import static org.junit.Assert.*;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;
import org.junit.Before;
import org.junit.Test;

public class UninitializedMachineStateTest {

  BeverageVendingMachine vendingMachine;
  UninitializedMachineState uninitializedState;

  @Before
  public void setUp() {
    vendingMachine = new BeverageVendingMachine();
    uninitializedState = new UninitializedMachineState(vendingMachine);
  }

  @Test
  public void addBeverages() {
    uninitializedState.initialize();
    assertEquals(6, vendingMachine.getBeverageList().size());
    assertNotEquals(null, vendingMachine.getBeverage("Americano"));
    assertNotEquals(null, vendingMachine.getBeverage("Green Tea"));
    assertEquals(null, vendingMachine.getBeverage("Hot Chocolate"));
  }

  @Test
  public void setDefaultPrices() {
    vendingMachine.setDefaultPrice(5);
    vendingMachine.initialize();
    Beverage espresso = vendingMachine.getBeverage("Espresso");
    Beverage yellowTea = vendingMachine.getBeverage("Yellow Tea");
    assertEquals(5, espresso.getPrice());
    assertEquals(5, yellowTea.getPrice());
  }
}