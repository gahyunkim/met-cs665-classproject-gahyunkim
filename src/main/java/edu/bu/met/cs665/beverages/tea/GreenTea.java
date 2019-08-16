package edu.bu.met.cs665.beverages.tea;

public class GreenTea implements Tea {
  private int price;
  private int temperature;
  private int brewTime;
  private int grams;

  // Constructor sets default price to 0.
  // Sets recommended temperature, brew time, and grams for *Black Tea* as default values.
  public GreenTea() {
    this.price = 0;
    this.temperature = 170;
    this.brewTime = 2;
    this.grams = 2;
  }

  // Creates tea using tea brewing properties
  public void make() {
    System.out.println("Heating water to " + temperature + " degrees...");
    System.out.println("Adding " + grams + " grams of green loose tea leaves...");
    System.out.println("Brewing for " + brewTime);
    System.out.println("Green Tea ready!");;
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
    return "Green Tea";
  }
}
