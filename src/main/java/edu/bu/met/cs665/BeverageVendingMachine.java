package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;

import edu.bu.met.cs665.state.BrewingMachineState;
import edu.bu.met.cs665.state.MachineState;
import edu.bu.met.cs665.state.ReadyMachineState;
import edu.bu.met.cs665.state.UninitializedMachineState;
import java.util.List;

public class BeverageVendingMachine {

  private MachineState machineState;

  private UninitializedMachineState uninitializedState;
  private ReadyMachineState readyState;
  private BrewingMachineState brewingState;

  private int defaultPrice = 2;

  private BeverageInventory inventory;

  // Creates machine with states and inventory
  public BeverageVendingMachine() {
    uninitializedState = new UninitializedMachineState(this);
    readyState = new ReadyMachineState(this);
    brewingState = new BrewingMachineState(this);

    machineState = uninitializedState;

    inventory = new BeverageInventory();
  }

  // Initializes machine
  public void initialize() {
    machineState.initialize();
  }

  // Requests user for beverage
  public void requestBeverage() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("What beverage would you like?");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  // Brews specified beverage
  public void brew(String beverageName) {
    machineState.brew(beverageName);
  }

  // Serves brewed beverage
  public void serve() {
    machineState.serve();
  }

  public String getMachineState() {
    return machineState.get();
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

  // Returns Beverage object in list given string name
  public Beverage getBeverage(String beverageName) {
    for (Beverage beverage : inventory.getBeverages()) {
      if (beverage.getName().equals(beverageName)) {
        return beverage;
      }
    }
    System.out.println("Beverage not found");
    return null;
  }

  public void setBeveragePrice(String beverageName, int price) {
    Beverage beverage = getBeverage(beverageName);
    beverage.setPrice(price);
  }

  // Retrieves price of beverage
  // If not found, return s-1
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
    return inventory.getBeverages();
  }

  public BeverageInventory getInventory() { return inventory; }

  // Stocks beverages in inventory
  public void stock() {
    inventory.stock();
  }

  // Stocks given beverage in inventory
  public void stock(String beverageName) {
    Beverage beverage = getBeverage(beverageName);
    if (beverage != null) {
      inventory.stockBeverage(beverage);
    }
  }

  // Stocks given list of beverages
  public void stock(List<Beverage> beverageList) {
     inventory.stock(beverageList);
  }
}
