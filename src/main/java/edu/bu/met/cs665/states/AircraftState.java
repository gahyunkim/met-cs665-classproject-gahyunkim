package edu.bu.met.cs665.states;

import java.time.LocalDate;

public interface AircraftState {

  void evaluate();

  void printResults();

  void performMaintenance();

  String get();

}
