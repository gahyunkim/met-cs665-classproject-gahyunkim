package edu.bu.met.cs665.beverages;

public interface Beverage {
  void setPrice(int price);

  int getPrice();

  String getName();

  void make();
}
