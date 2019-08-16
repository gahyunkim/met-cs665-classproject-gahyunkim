package edu.bu.met.cs665.state;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;

public class ReadyState implements State {

  BeverageVendingMachine vendingMachine;

  public ReadyState(BeverageVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  public void initialize() {
    System.out.println("Machine already initialized");
    vendingMachine.requestBeverage();
  }

  public void brew(String beverageName) {
    Beverage beverage = vendingMachine.getBeverage(beverageName);
    if (beverage != null) {
      System.out.println("\n" + beverageName + " costs $" + beverage.getPrice());
      System.out.println("------------------------------------------");
      System.out.println("Starting brew process for " + beverageName + "!");
      vendingMachine.setBeverage(beverage);
      vendingMachine.setState(vendingMachine.getBrewingState());
    }
  }

  public void serve() {
    System.out.println("Please specify which beverage to brew");
  }

  public String getState() {
    String state = "Ready";
    System.out.println(state);
    return state;
  }
}
