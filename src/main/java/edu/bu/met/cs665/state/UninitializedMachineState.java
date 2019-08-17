package edu.bu.met.cs665.state;

import edu.bu.met.cs665.BeverageVendingMachine;
import edu.bu.met.cs665.beverages.Beverage;
import edu.bu.met.cs665.beverages.coffee.Americano;
import edu.bu.met.cs665.beverages.coffee.Espresso;
import edu.bu.met.cs665.beverages.coffee.LatteMacchiato;
import edu.bu.met.cs665.beverages.tea.BlackTea;
import edu.bu.met.cs665.beverages.tea.GreenTea;
import edu.bu.met.cs665.beverages.tea.YellowTea;
import java.util.ArrayList;
import java.util.List;

public class UninitializedMachineState implements MachineState {

  private BeverageVendingMachine vendingMachine;

  public UninitializedMachineState(BeverageVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  // Adds and stocks beverages
  // Sets default price
  // Sets next state to ready state
  public void initialize() {
    addBeverages();
    setDefaultBeveragePrices();
    vendingMachine.setMachineState(vendingMachine.getReadyState());
  }

  // Adds beverages to inventory and stocks
  private void addBeverages() {
    List<Beverage> beverageList = new ArrayList<Beverage>();

    beverageList.add(new Americano());
    beverageList.add(new Espresso());
    beverageList.add(new LatteMacchiato());
    beverageList.add(new BlackTea());
    beverageList.add(new GreenTea());
    beverageList.add(new YellowTea());

    vendingMachine.stock(beverageList);
  }

  // Sets same default price for all beverages
  private void setDefaultBeveragePrices() {
    int price = vendingMachine.getDefaultPrice();
    for (Beverage beverage : vendingMachine.getBeverageList()) {
      beverage.setPrice(price);
      System.out.println("Set price of " + beverage.getName() + " to $" + price);
    }
  }

  // Cannot brew without finishing initialization
  public void brew(String beverageName) {
    System.out.println("Cannot brew, not fully initialized yet");
  }

  // Cannot serve without finishing initialization
  public void serve() {
    System.out.println("Cannot serve, not fully initialized yet");
  }

  public String get() {
    String state = "Uninitialized";
    System.out.println(state);
    return state;
  }
}
