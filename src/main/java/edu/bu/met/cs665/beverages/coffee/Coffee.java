package edu.bu.met.cs665.beverages.coffee;

import edu.bu.met.cs665.beverages.Beverage;

interface Coffee extends Beverage {
  // Sets shots of espresso for coffee drink
  void setShots(int shots);

  int getShots();
}
