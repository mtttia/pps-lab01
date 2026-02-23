package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEachInitializeSmartDoorLock(){
        smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    void testLockWithoutPin(){
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }
}
