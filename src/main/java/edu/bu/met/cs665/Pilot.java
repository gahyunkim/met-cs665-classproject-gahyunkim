package edu.bu.met.cs665;

public interface Pilot {

  // Pilot receives mission info and is tasked to it
  void update(Mission mission);

  // Pilot is tasked to mission
  void setMission(Mission mission);

  Mission getMission();

  void setName(String name);

  String getName();

}
