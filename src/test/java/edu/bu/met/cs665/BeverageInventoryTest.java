package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.beverages.Beverage;
import edu.bu.met.cs665.beverages.coffee.Americano;
import edu.bu.met.cs665.beverages.coffee.Espresso;
import edu.bu.met.cs665.beverages.tea.BlackTea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BeverageInventoryTest {

  BeverageInventory singleInventory;
  Beverage espresso = new Espresso();

  @Before
  public void setUp() {
    HashMap<Beverage, Integer> espressoInventory = new HashMap<>();
    espressoInventory.put(espresso, 1);

    singleInventory = new BeverageInventory();
    singleInventory.setInventory(espressoInventory);
  }

  @Test
  public void decrementBeverageCount() {
    assertEquals(1, singleInventory.getCount(espresso));

    singleInventory.decrementBeverage(espresso);
    assertEquals(0, singleInventory.getCount(espresso));
  }

  @Test
  public void stockBeverage() {
    singleInventory.setStockCount(2);
    singleInventory.stock();
    assertEquals(2, singleInventory.getCount(espresso));
  }

  @Test
  public void restockBeverage() {
    singleInventory.setStockCount(5);
    singleInventory.stockBeverage(espresso);;
    assertEquals(5, singleInventory.getCount(espresso));
  }

  @Test
  public void stockMultipleBeverages() {
    Beverage blackTea = new BlackTea();
    Beverage americano = new Americano();

    List<Beverage> beverages = new ArrayList<>();
    beverages.add(blackTea);
    beverages.add(americano);

    BeverageInventory inventory = new BeverageInventory();
    inventory.stock(beverages);
  }
}