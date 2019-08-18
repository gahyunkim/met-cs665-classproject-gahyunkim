package edu.bu.met.cs665;

import edu.bu.met.cs665.parts.PartsInventoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AircraftTest.class,
    EngineHealthTest.class,
    PartsInventoryTest.class
})
public class AllTests {

}
