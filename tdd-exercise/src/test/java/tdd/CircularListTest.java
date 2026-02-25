package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int QUEUE_VALUE = 5;
    private static final int QUEUE_SIZE = 5;

    private CircularQueue circularQueue;

    @BeforeEach
    void beforeEach(){
        circularQueue = new CircularQueueImpl(QUEUE_SIZE);
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

    @Test
    void testQueueStoreValuesAreStoredInACircularWay(){
        for(int i = 0; i < QUEUE_SIZE; i++){
            circularQueue.enqueue(i);
        }
        circularQueue.enqueue(QUEUE_VALUE);
        for(int i = 1; i < QUEUE_SIZE; i++){
            assertEquals(i, circularQueue.dequeue());
        }
        assertEquals(QUEUE_VALUE, circularQueue.dequeue());
    }

    @Test
    void testCannotDequeueOnEmptyQueue(){
        assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
    }

    @Test
    void testAfterDequeueSizeIsCorrect(){
        circularQueue.enqueue(QUEUE_VALUE);
        circularQueue.dequeue();
        assertEquals(0, circularQueue.size());
    }
}
