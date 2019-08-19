package edu.bu.met.cs665;

public interface AircraftState {

  void evaluate();

  void printResults();

  void performMaintenance();

  String get();

}
