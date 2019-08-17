package edu.bu.met.cs665.state;

public interface MachineState {

  // Sets machine up with beverages
  void initialize();

  // Searches and creates beverage
  void brew(String beverageName);

  // Serves finished beverage to user
  void serve();

  // Returns name of state
  String get();
}
