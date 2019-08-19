package edu.bu.met.cs665;

import edu.bu.met.cs665.parts.PartsInventoryTest;
import edu.bu.met.cs665.state.CriticalAircraftStateTest;
import edu.bu.met.cs665.state.HealthyAircraftStateTest;
import edu.bu.met.cs665.state.WarningAircraftStateTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BuildAircraftTest.class,
    EngineHealthTest.class,
    PartsInventoryTest.class,
    HealthyAircraftStateTest.class,
    WarningAircraftStateTest.class,
    CriticalAircraftStateTest.class,
    MissionNotificationTest.class,
    MissionTest.class
})
public class AllTests {

}
