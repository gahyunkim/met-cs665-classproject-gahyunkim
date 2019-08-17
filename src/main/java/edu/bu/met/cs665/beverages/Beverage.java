package edu.bu.met.cs665.beverages;

public interface Beverage {

  void setPrice(int price);

  int getPrice();

  // Returns name of beverage
  String getName();

  // Creates beverage and prints out steps in progress
  void make();
}
