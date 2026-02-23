package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int VALID_PIN = 1234;
    private static final int INVALID_PIN = 4321;
    private static final int MAX_ATTEMPTS = 2;

    private SmartDoorLock smartDoorLock;

    private void lockSmartDoor (){
        smartDoorLock.setPin(VALID_PIN);
        smartDoorLock.lock();
    }

    private void blockSmartDoor(){
        lockSmartDoor();
        for(int i = 0; i < smartDoorLock.getMaxAttempts(); i++){
            smartDoorLock.unlock(INVALID_PIN);
        }
    }

    @BeforeEach
    void beforeEachInitializeSmartDoorLock(){
        smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
    }

    @Test
    void testLockWithoutPin(){
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    @Test
    void testLockWithPin(){
        lockSmartDoor();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testCanUnlockWithValidPin(){
        lockSmartDoor();
        smartDoorLock.unlock(VALID_PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testCannotUnlockWithInvalidPin(){
        lockSmartDoor();
        smartDoorLock.unlock(INVALID_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testBlockedAfterManyFailedUnlockAttempts(){
        blockSmartDoor();
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    void testAfterSuccessUnlockIsNotBlocked(){
        lockSmartDoor();
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void testWhenBlockedCannotUnlock(){
        blockSmartDoor();
        smartDoorLock.unlock(VALID_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testAfterSuccessUnlockTheFailureAttemptCountReset(){
        lockSmartDoor();
        smartDoorLock.unlock(INVALID_PIN);
        smartDoorLock.unlock(VALID_PIN);
        smartDoorLock.unlock(INVALID_PIN);
        assertEquals(1, smartDoorLock.getFailedAttempts());
    }

}
