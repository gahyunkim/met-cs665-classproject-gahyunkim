package edu.bu.met.cs665.state;

public interface State {

  void initialize();

  void brew(String beverageName);

  void serve();

  String getState();
}
