package edu.bu.met.cs665.state;

import edu.bu.met.cs665.BeverageVendingMachine;

public class BrewingMachineState implements MachineState {

  private BeverageVendingMachine vendingMachine;

  public BrewingMachineState(BeverageVendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  // Machine already initialized and working
  public void initialize() {
    System.out.println("Machine already initialized, currently brewing beverage");
  }

  // Cannot brew while another drink's brew is in process
  public void brew(String beverageName) {
    System.out.println("Please wait, busy brewing a beverage");
  }

  // Dispenses beverage and returns to ready state
  public void serve() {
    System.out.println("Dispensing beverage... Enjoy!");
    System.out.println("------------------------------------------");

    vendingMachine.requestBeverage();
    vendingMachine.setMachineState(vendingMachine.getReadyState());
  }

  public String get() {
    String state = "Brewing";
    System.out.println(state);
    return state;
  }
}
