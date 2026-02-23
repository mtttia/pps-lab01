package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;
    private static final int PUSH_VALUE = 1;
    private static final int MINOR_VALUE = 3;
    private static final int GREATER_VALUE = 5;
    private static final int INITIAL_STACK_SIZE = 0;

    private void pushValue(){
        pushValue(PUSH_VALUE);
    }

    private void pushValue(int value){
        minMaxStack.push(value);
    }

    private void pushValue(int firstValue, int secondValue){
        pushValue(firstValue);
        pushValue(secondValue);
    }

    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testInitiallyStackIsEmpty(){
        assertTrue(minMaxStack.isEmpty());
        assertEquals(INITIAL_STACK_SIZE, minMaxStack.size());
    }

    @Test
    void testCannotPopOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testPopAfterPushValue(){
        pushValue();
        assertEquals(PUSH_VALUE, minMaxStack.pop());
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testCannotPeekOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    void testCanPeekAfterPushValue() {
        pushValue();
        assertEquals(PUSH_VALUE, minMaxStack.peek());
        assertEquals(1, minMaxStack.size());
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    void testCannotGetMinValueOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterPushingValues(){
        pushValue(MINOR_VALUE, GREATER_VALUE);
        assertEquals(MINOR_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterPushValue(){
        pushValue(MINOR_VALUE);
        assertEquals(MINOR_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterManyPushAndPop() {
        pushValue(GREATER_VALUE, MINOR_VALUE);
        minMaxStack.pop();
        assertEquals(GREATER_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCannotGetMaxValueOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }

    @Test
    void testCanGetMaxValueAfterPushingValues(){
        pushValue(GREATER_VALUE, MINOR_VALUE);
        assertEquals(GREATER_VALUE, minMaxStack.getMax());
    }

    @Test
    void testCanGetMaxValueAfterManyPushAndPop() {
        pushValue(MINOR_VALUE, GREATER_VALUE);
        minMaxStack.pop();
        assertEquals(MINOR_VALUE, minMaxStack.getMax());
    }
}