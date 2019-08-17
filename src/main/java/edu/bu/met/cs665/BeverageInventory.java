package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeverageInventory {

  // Container that stores beverage and count (# available)
  private HashMap<Beverage, Integer> inventory;
  private int count = 3;

  public BeverageInventory() {
    inventory = new HashMap<>();
  }

  // Stocks all beverages with same count
  public void stock() {
    for (Beverage beverage : inventory.keySet()) {
      inventory.put(beverage, count);
    }
  }

  // Given list, stocks all beverages
  public void stock(List<Beverage> beverageList) {
    for (Beverage beverage : beverageList) {
      inventory.put(beverage, count);
    }
  }

  // Stocks given beverage to count
  public void stockBeverage(Beverage beverage) {
    inventory.put(beverage, count);
  }

  public void setStockCount(int count) {
    this.count = count;
  }

  // Retrieves number available of given beverage
  public int getCount(Beverage beverage) {
    return inventory.get(beverage);
  }

  // Decrements count of given beverage
  public void decrementBeverage(Beverage beverage) {
    int currentCount = inventory.get(beverage);
    inventory.put(beverage, --currentCount);
  }

  // Returns list of beverages
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
