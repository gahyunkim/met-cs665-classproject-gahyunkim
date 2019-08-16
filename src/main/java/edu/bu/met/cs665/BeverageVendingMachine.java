package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;

import edu.bu.met.cs665.state.BrewingState;
import edu.bu.met.cs665.state.ReadyState;
import edu.bu.met.cs665.state.State;
import edu.bu.met.cs665.state.UninitializedState;
import java.util.List;

public class BeverageVendingMachine {

  private State state;

  private UninitializedState uninitializedState;
  private ReadyState readyState;
  private BrewingState brewingState;

  private Beverage beverage;
  private int defaultPrice = 2;

  private List<Beverage> beverageList;

  public BeverageVendingMachine() {
    uninitializedState = new UninitializedState(this);
    readyState = new ReadyState(this);
    brewingState = new BrewingState(this);

    state = uninitializedState;
  }

  public void initialize() {
    state.initialize();
  }

  public void printBeverageList() {
    for (Beverage beverage : beverageList) {
      System.out.println(beverage.getName());
    }
  }

  public void requestBeverage() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("What beverage would you like?");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public void brew(String beverageName) {
    state.brew(beverageName);
  }

  public void serve() {
    state.serve();
  }

  public String getState() {
    return state.getState();
  }

  public void setState(State state) {
    this.state = state;
  }

  public State getUninitializedState() {
    return uninitializedState;
  }

  public State getBrewingState() {
    return brewingState;
  }

  public State getReadyState() {
    return readyState;
  }

  public void setBeverage(Beverage beverage) {
    this.beverage = beverage;
  }

  public Beverage getBeverage() {
    return beverage;
  }

  public void setBeveragePrice(String beverageName, int price) {
    Beverage beverage = getBeverage(beverageName);
    beverage.setPrice(price);
  }

  public int getBeveragePrice(String beverageName) {
    Beverage beverage = getBeverage(beverageName);
    if (beverage != null) {
      int price = beverage.getPrice();
      System.out.println("Beverage price of " + beverageName + ": " + price);
      return price;
    }
    return -1;
  }

  public int getDefaultPrice() {
    return defaultPrice;
  }

  public void setDefaultPrice(int defaultPrice) {
    this.defaultPrice = defaultPrice;
  }

  public Beverage getBeverage(String beverageName) {
    for (Beverage beverage : beverageList) {
      if (beverage.getName().equals(beverageName)) {
        return beverage;
      }
    }
    System.out.println("Beverage not found");
    return null;
  }

  public boolean isInitialized() {
    return state != uninitializedState;
  }

  public boolean isReady() {
    return state == readyState;
  }

  public boolean isBrewing() {
    return state == brewingState;
  }

  public List<Beverage> getBeverageList() {
    return beverageList;
  }

  public void setBeverageList(List<Beverage> beverageList) {
    this.beverageList = beverageList;
  }

}
