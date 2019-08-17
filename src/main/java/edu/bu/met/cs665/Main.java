package edu.bu.met.cs665;

public class Main {

  /**
   * A main method to run examples.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine();
    beverageVendingMachine.initialize();

    beverageVendingMachine.setBeveragePrice("Americano", 1);
    beverageVendingMachine.setBeveragePrice("Espresso", 3);
    beverageVendingMachine.setBeveragePrice("Latte Macchiato", 1);
    beverageVendingMachine.setBeveragePrice("Black Tea", 2);
    beverageVendingMachine.setBeveragePrice("Yellow Tea", 2);
    beverageVendingMachine.setBeveragePrice("Green Tea", 1);

    beverageVendingMachine.brew("Latte Macchiato");
    beverageVendingMachine.serve();

    beverageVendingMachine.brew("Espresso");
    beverageVendingMachine.serve();

    beverageVendingMachine.brew("Americano");
    beverageVendingMachine.serve();

    beverageVendingMachine.brew("Black Tea");
    beverageVendingMachine.serve();

    beverageVendingMachine.brew("Green Tea");
    beverageVendingMachine.serve();

    beverageVendingMachine.brew("Yellow Tea");
    beverageVendingMachine.serve();
  }
}