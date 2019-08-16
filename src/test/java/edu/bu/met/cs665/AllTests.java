package edu.bu.met.cs665;

import edu.bu.met.cs665.state.ReadyMachineStateTest;
import edu.bu.met.cs665.state.UninitializedMachineStateTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BeveragePricesTest.class,
    MachineBrewTest.class,
    MachineMachineStateTest.class,
    ReadyMachineStateTest.class,
    UninitializedMachineStateTest.class,
    BeverageInventoryTest.class
})
public class AllTests {

}
