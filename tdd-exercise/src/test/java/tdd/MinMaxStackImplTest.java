package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;
    private static final int PUSH_VALUE = 1;
    private static final int MINOR_VALUE = 3;
    private static final int GREATER_VALUE = 5;

    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testCannotPopOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testPopAfterPushValue(){
        minMaxStack.push(PUSH_VALUE);
        assertEquals(PUSH_VALUE, minMaxStack.pop());
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testCannotPeekOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    void testCanPeekAfterPushValue() {
        minMaxStack.push(PUSH_VALUE);
        assertEquals(PUSH_VALUE, minMaxStack.peek());
        assertDoesNotThrow(() -> minMaxStack.pop());
    }

    @Test
    void testCannotGetMinValueOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterPushingValues(){
        minMaxStack.push(MINOR_VALUE);
        minMaxStack.push(GREATER_VALUE);
        assertEquals(MINOR_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterPushValue(){
        minMaxStack.push(MINOR_VALUE);
        assertEquals(MINOR_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCanGetMinValueAfterManyPushAndPop() {
        minMaxStack.push(GREATER_VALUE);
        minMaxStack.push(MINOR_VALUE);
        minMaxStack.pop();
        assertEquals(GREATER_VALUE, minMaxStack.getMin());
    }

    @Test
    void testCannotGetMaxValueOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }

    @Test
    void testCanGetMaxValueAfterPushingValues(){
        minMaxStack.push(GREATER_VALUE);
        minMaxStack.push(MINOR_VALUE);
        assertEquals(GREATER_VALUE, minMaxStack.getMax());
    }

    @Test
    void testCanGetMaxValueAfterManyPushAndPop() {
        minMaxStack.push(MINOR_VALUE);
        minMaxStack.push(GREATER_VALUE);
        minMaxStack.pop();
        assertEquals(MINOR_VALUE, minMaxStack.getMax());
    }
}