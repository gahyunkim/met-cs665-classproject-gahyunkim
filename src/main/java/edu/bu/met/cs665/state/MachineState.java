package edu.bu.met.cs665.state;

public interface MachineState {

  void initialize();

  void brew(String beverageName);

  void serve();

  String get();
}
