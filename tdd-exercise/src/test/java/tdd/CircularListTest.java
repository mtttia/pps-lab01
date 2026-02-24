package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int QUEUE_VALUE = 5;

    private CircularQueue circularQueue;

    @BeforeEach
    void beforeEach(){
        circularQueue = new CircularQueueImpl();
    }

    @Test
    void testInitiallyEmpty(){
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    void testEnqueueFirstValue(){
        circularQueue.enqueue(QUEUE_VALUE);
        assertEquals(1, circularQueue.size());
        assertFalse(circularQueue.isEmpty());
    }
}
