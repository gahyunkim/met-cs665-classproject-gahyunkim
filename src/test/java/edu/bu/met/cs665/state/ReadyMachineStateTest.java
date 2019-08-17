package edu.bu.met.cs665.state;

import static org.junit.Assert.*;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;
import edu.bu.met.cs665.beverages.coffee.Espresso;
import java.util.List;
import org.jaxen.util.SingletonList;
import org.junit.Test;

public class ReadyMachineStateTest {

  @Test
  public void brewDecrementsInventory() {
    BeverageVendingMachine vendingMachine = new BeverageVendingMachine();
    ReadyMachineState readyMachineState = new ReadyMachineState(vendingMachine);

    Beverage espresso = new Espresso();
    List<Beverage> espressoList = new SingletonList(espresso);
    vendingMachine.stock(espressoList);

    int originalCount = vendingMachine.getInventory().getCount(espresso);
    readyMachineState.brew("Espresso");
    assertEquals(originalCount - 1, vendingMachine.getInventory().getCount(espresso));
  }
}