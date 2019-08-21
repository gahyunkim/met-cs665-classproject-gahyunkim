package edu.bu.met.cs665;

public interface AircraftState {

  // Assesses status of aircraft based on part inventory's maintenance status
  void evaluate();

  // Prints evaluation results from assessment
  void printResults();

  // Performs required maintenance based on critical/warning parts
  void performMaintenance();

  // Retrieves status name
  String get();

}
