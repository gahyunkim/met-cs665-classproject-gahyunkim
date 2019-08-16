package edu.bu.met.cs665.beverages.coffee;

public class Espresso implements Coffee {

  private int price;
  private int shots;
  private String name = "Espresso";

  // Constructor sets default price to 0
  // Sets # shots to 1 as default
  public Espresso() {
    this.price = 0;
    this.shots = 1;
  }

  // Can be instantiated with specific # shots
  public Espresso(int shots) {
    this.price = 0;
    this.shots = shots;
  }

  // Executes actions needed to create drink
  public void make() {
    grindBeans();
    dose();
    tamp();
    brew();
    pour();
    System.out.println(name + " ready!");
  }

  private void grindBeans() {
    System.out.println("Grinding beans...");
  }

  // Uses seven grams of coffee for one shot
  private void dose() {
    int grams = 7 * this.shots;
    System.out.println("Dosing " + grams + " grams of coffee...");
  }

  private void tamp() {
    System.out.println("Tamping...");
  }

  private void brew() {
    System.out.println("Brewing...");
  }

  private void pour() {
    System.out.println("Pouring...");
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }

  public void setShots(int shots) {
    this.shots = shots;
  }

  public int getShots() {
    return shots;
  }

  public String getName() {
    return name;
  }
}
