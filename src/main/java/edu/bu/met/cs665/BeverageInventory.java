package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeverageInventory {

  private HashMap<Beverage, Integer> inventory;
  private int count = 3;

  public BeverageInventory() {
    inventory = new HashMap<>();
  }

  public void stock() {
    for (Beverage beverage : inventory.keySet()) {
      inventory.put(beverage, count);
    }
  }

  public void stock(List<Beverage> beverageList) {
    for (Beverage beverage : beverageList) {
      inventory.put(beverage, count);
    }
  }

  public void stockBeverage(Beverage beverage) {
    inventory.put(beverage, count);
  }

  public void setStockCount(int count) {
    this.count = count;
  }

  public int getCount(Beverage beverage) {
    return inventory.get(beverage);
  }

  public void decrementBeverage(Beverage beverage) {
    int currentCount = inventory.get(beverage);
    inventory.put(beverage, --currentCount);
  }

  public List<Beverage> getBeverages() {
    List<Beverage> beverages = new ArrayList<>();
    beverages.addAll(inventory.keySet());
    return beverages;
  }

  public void setInventory(HashMap<Beverage, Integer> inventory) {
    this.inventory = inventory;
  }

  public HashMap<Beverage, Integer> getInventory() {
    return inventory;
  }

}
