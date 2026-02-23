package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int VALID_PIN = 1234;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEachInitializeSmartDoorLock(){
        smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    void testLockWithoutPin(){
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    @Test
    void testLockWithPin(){
        smartDoorLock.setPin(VALID_PIN);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testCanUnlockWithValidPin(){
        smartDoorLock.setPin(VALID_PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(VALID_PIN);
        assertFalse(smartDoorLock.isLocked());
    }
}
