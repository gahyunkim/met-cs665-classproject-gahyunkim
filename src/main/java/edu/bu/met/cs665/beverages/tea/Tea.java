package edu.bu.met.cs665.beverages.tea;

import edu.bu.met.cs665.beverages.Beverage;

interface Tea extends Beverage {
  // Sets water temperature for steeping
  void setTemperature(int temperature);

  // Sets time for steeping
  void setBrewTime(int time);

  // Sets grams of tea added to water
  void setGrams(int grams);

  int getTemperature();

  int getBrewTime();

  int getGrams();
}
