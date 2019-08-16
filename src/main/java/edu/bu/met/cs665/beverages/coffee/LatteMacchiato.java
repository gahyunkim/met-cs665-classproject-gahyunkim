package edu.bu.met.cs665.beverages.coffee;

public class LatteMacchiato implements Coffee {

  private int price;
  private int shots;
  private String name = "Latte Macchiato";

  // Constructor sets default price to 0
  // Sets # espresso shots to 3 as default
  public LatteMacchiato() {
    this.price = 0;
    this.shots = 3;
  }

  // Creates Latte Macchiato drink
  // Uses Espresso with specified # shots
  // Steams milk and mixes with espresso to finish.
  public void make() {
    Espresso espresso = new Espresso(this.shots);
    espresso.make();
    steamMilk();
    System.out.println("Pouring milk...");
    System.out.println(name + " ready!");
  }

  // Steams and froths milk, used later with espresso to make drink
  private void steamMilk() {
    System.out.println("Steaming milk...");
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
