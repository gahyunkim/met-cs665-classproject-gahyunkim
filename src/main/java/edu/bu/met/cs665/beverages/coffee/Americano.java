package edu.bu.met.cs665.beverages.coffee;

public class Americano implements Coffee {

  private int price;
  private int shots;
  private String name = "Americano";

  // Constructor sets default price to 0
  // Sets # espresso shots to 2 as default
  public Americano() {
    this.price = 0;
    this.shots = 2;
  }

  // Creates espresso using number of shots
  public void make() {
    Espresso espresso = new Espresso(this.shots);
    espresso.make();
    heatWater();
    System.out.println(name + " ready!");
  }

  // Heats water, used later with espresso to make drink
  private void heatWater() {
    System.out.println("Heating water...");
    System.out.println("Water ready!");
    System.out.println("Pouring water");
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
