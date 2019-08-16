package edu.bu.met.cs665.beverages.tea;

public class BlackTea implements Tea {
  private int price;
  private int temperature;
  private int brewTime;
  private int grams;

  // Constructor sets default price to 0.
  // Sets recommended temperature, brew time, and grams for *Black Tea* as default values.
  public BlackTea() {
    this.price = 0;
    this.temperature = 200;
    this.brewTime = 4;
    this.grams = 2;
  }

  // Creates tea using tea brewing properties.
  public void make() {
    System.out.println("Heating water to " + this.temperature + " degrees...");
    System.out.println("Adding " + this.grams + " grams of black loose tea leaves...");
    System.out.println("Brewing for " + this.brewTime);;
    System.out.println("Black Tea ready!");;
  }

  // Sets temperature for steeping tea
  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  public int getTemperature() {
    return this.temperature;
  }

  // Sets time for steeping tea
  public void setBrewTime(int time) {
    this.brewTime = time;
  }

  public int getBrewTime() {
    return this.brewTime;
  }

  // Sets grams to add for tea
  public void setGrams(int grams) {
    this.grams = grams;
  }

  public int getGrams() {
    return this.grams;
  }

  // Sets price for tea
  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }

  public String getName() {
    return "Black Tea";
  }
}
