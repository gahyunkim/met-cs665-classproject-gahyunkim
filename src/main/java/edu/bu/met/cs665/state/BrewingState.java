package edu.bu.met.cs665.state;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;

public class BrewingState implements State {

  private BeverageVendingMachine vendingMachine;

  public BrewingState(BeverageVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  public void initialize() {
    System.out.println("Machine already initialized, currently brewing beverage");
  }

  public void brew(String beverageName) {
    System.out.println("Please wait, busy brewing a beverage");
    Beverage beverage = vendingMachine.getBeverage();
    beverage.make();
  }

  public void serve() {
    System.out.println("Dispensing beverage... Enjoy!");
    System.out.println("------------------------------------------");

    vendingMachine.requestBeverage();
    vendingMachine.setState(vendingMachine.getReadyState());
  }

  public String getState() {
    String state = "Brewing";
    System.out.println(state);
    return state;
  }
}
