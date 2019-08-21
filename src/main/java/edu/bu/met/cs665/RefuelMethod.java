package edu.bu.met.cs665;

public interface RefuelMethod {

  // Executes refueling for given aircraft using its refueling rate spec
  void refuel(Aircraft aircraft);

  String getName();

}
