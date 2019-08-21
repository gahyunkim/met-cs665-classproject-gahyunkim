package edu.bu.met.cs665;

public interface Pilot {

  void update(Mission mission);

  void setMission(Mission mission);

  Mission getMission();

  void setName(String name);

  String getName();

}
