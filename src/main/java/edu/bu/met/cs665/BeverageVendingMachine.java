package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;

import edu.bu.met.cs665.state.BrewingMachineState;
import edu.bu.met.cs665.state.ReadyMachineState;
import edu.bu.met.cs665.state.MachineState;
import edu.bu.met.cs665.state.UninitializedMachineState;
import java.util.List;

public class BeverageVendingMachine {

  private MachineState machineState;

  private UninitializedMachineState uninitializedState;
  private ReadyMachineState readyState;
  private BrewingMachineState brewingState;

  private Beverage beverage;
  private int defaultPrice = 2;

  private List<Beverage> beverageList;

  public BeverageVendingMachine() {
    uninitializedState = new UninitializedMachineState(this);
    readyState = new ReadyMachineState(this);
    brewingState = new BrewingMachineState(this);

    machineState = uninitializedState;
  }

  public void initialize() {
    machineState.initialize();
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
    machineState.brew(beverageName);
  }

  public void serve() {
    machineState.serve();
  }

  public String getMachineState() {
    return machineState.getState();
  }

  public void setMachineState(MachineState machineState) {
    this.machineState = machineState;
  }

  public MachineState getUninitializedState() {
    return uninitializedState;
  }

  public MachineState getBrewingState() {
    return brewingState;
  }

  public MachineState getReadyState() {
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
    return machineState != uninitializedState;
  }

  public boolean isReady() {
    return machineState == readyState;
  }

  public boolean isBrewing() {
    return machineState == brewingState;
  }

  public List<Beverage> getBeverageList() {
    return beverageList;
  }

  public void setBeverageList(List<Beverage> beverageList) {
    this.beverageList = beverageList;
  }

}
