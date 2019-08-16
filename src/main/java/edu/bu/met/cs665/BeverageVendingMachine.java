package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Beverage;
import edu.bu.met.cs665.beverages.coffee.Americano;
import edu.bu.met.cs665.beverages.coffee.Espresso;
import edu.bu.met.cs665.beverages.coffee.LatteMacchiato;
import edu.bu.met.cs665.beverages.tea.BlackTea;
import edu.bu.met.cs665.beverages.tea.GreenTea;
import edu.bu.met.cs665.beverages.tea.YellowTea;
import java.util.ArrayList;
import java.util.List;

public class BeverageVendingMachine {

  private boolean initialized;
  private boolean ready;
  private boolean brewing;

  private List<Beverage> beverageList;

  // Construct beverage vending machine and adds required beverages to list
  // Default sets all states to false (initialzed, ready, brewing)
  public BeverageVendingMachine() {
    initialized = false;
    ready = false;
    brewing = false;

    beverageList = new ArrayList<Beverage>();
    beverageList.add(new Americano());
    beverageList.add(new Espresso());
    beverageList.add(new LatteMacchiato());
    beverageList.add(new BlackTea());
    beverageList.add(new GreenTea());
    beverageList.add(new YellowTea());
  }

  // Returns and prints out summary of machine status
  // If it is not initialized, it is either brewing or uninitialized
  // Prints out appropriate reason if not ready
  public String getStateSummary() {
    String initialization = initialized ? "initialized" : "";
    String readiness;
    if (ready && !brewing) {
      readiness = ", ready";
    } else if (brewing) {
      readiness = ", not ready (currently brewing)";
    } else {
      readiness = "uninitialized, not ready";
    }

    String summary = initialization + readiness;

    System.out.println("\nBeverage vending machine status:");
    System.out.println(summary);
    return summary;
  }

  // Iterates through list of beverages
  // Makes sure price is set (*cannot equal 0)
  // If a price is not set, will say which beverage needs price set and returns
  public void initialize() {
    for (Beverage beverage : beverageList) {
      if (beverage.getPrice() == 0) {
        System.out.println("Need to set price for " + beverage.getName());
        return;
      }
    }

    System.out.println("\nInitializing machine...");
    System.out.println("Ready for order!");

    this.initialized = true;
    this.ready = true;
    requestBeverage();
  }

  // Given string name of beverage and its price,
  // Finds and sets appropriate beverage in list with given price.
  public void setBeveragePrice(String beverageName, int price) {
    Beverage beverage = getBeverage(beverageName);
    if (beverage != null) {
      beverage.setPrice(price);
      System.out.println("Set price of " + beverageName + " to $" + price);
    }
  }

  // Prints all available beverages in beverage list
  private void printBeverageList() {
    for (Beverage beverage : beverageList) {
      System.out.println(beverage.getName());
    }
  }

  // Requests specific beverage to vend
  private void requestBeverage() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("What beverage would you like?");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  // Finds specified beverage, given its String name, in beverage list
  // If not found, prints list and asks for name of available beverages.
  private Beverage getBeverage(String beverageName) {
    for (Beverage beverage : beverageList) {
      if (beverage.getName().equals(beverageName)) {
        return beverage;
      }
    }
    System.out.println("Could not find that beverage.");
    System.out.println("Current beverages served:");
    printBeverageList();
    return null;
  }

  // Returns listed price of specified beverage
  public int getBeveragePrice(String beverageName) {
    Beverage beverage = getBeverage(beverageName);
    if (beverage != null) {
      return beverage.getPrice();
    }
    return -1;
  }

  // Brews specified beverage
  // First, prints out listed cost of beverage
  // Cannot brew if not initialized or is in process of brewing another drink
  public void brew(String beverageName) {
    if (ready && !brewing) {
      Beverage beverage = getBeverage(beverageName);
      if (beverage != null) {
        System.out.println("\n" + beverageName + " costs $" + getBeveragePrice(beverageName));
        System.out.println("------------------------------------------");
        System.out.println("Starting brew process for " + beverageName + "!");
        ready = false;
        brewing = true;
        beverage.make();
      }
    } else {
      if (!initialized) {
        System.out.println("Please initialize machine.");
      }
      if (brewing) {
        System.out.println("Can only brew one drink at at time, please brew later.");
      }
    }
  }

  // Serves drink that is finishing brewing
  // Sets state of machine back to original (after initialization)
  // Requests beverage again
  public void serve() {
    if (brewing) {
      brewing = false;
      ready = true;
      System.out.println("Dispensing beverage... Enjoy!");
      System.out.println("------------------------------------------");
      requestBeverage();
    } else {
      System.out.println("Not brewing a drink, please request a beverage.");
    }
  }

  public boolean isInitialized() {
    return this.initialized;
  }

  public boolean isReady() {
    return this.ready;
  }

  public boolean isBrewing() {
    return this.brewing;
  }
}
