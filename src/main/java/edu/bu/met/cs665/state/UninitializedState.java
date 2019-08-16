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

public class UninitializedState implements State {

  BeverageVendingMachine vendingMachine;

  public UninitializedState(BeverageVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  public void initialize() {
    addBeverages();
    setDefaultBeveragePrices();
    vendingMachine.setState(vendingMachine.getReadyState());
  }

  private void addBeverages() {
    List<Beverage> beverageList = new ArrayList<Beverage>();

    beverageList.add(new Americano());
    beverageList.add(new Espresso());
    beverageList.add(new LatteMacchiato());
    beverageList.add(new BlackTea());
    beverageList.add(new GreenTea());
    beverageList.add(new YellowTea());

    vendingMachine.setBeverageList(beverageList);
  }

  private void setDefaultBeveragePrices() {
    int price = vendingMachine.getDefaultPrice();
    for (Beverage beverage : vendingMachine.getBeverageList()) {
      beverage.setPrice(price);
      System.out.println("Set price of " + beverage.getName() + " to $" + price);
    }
  }

  public void brew(String beverageName) {
    System.out.println("Cannot brew, not fully initialized yet");
  }

  public void serve() {
    System.out.println("Cannot serve, not fully initialized yet");
  }

  public String getState() {
    String state = "Uninitialized";
    System.out.println(state);
    return state;
  }
}
