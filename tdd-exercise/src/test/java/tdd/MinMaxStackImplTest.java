package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;
    private static final int PUSH_VALUE = 1;

    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testCannotPopOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    void testPopAfterPushingAValue(){
        minMaxStack.push(PUSH_VALUE);
        assertEquals(PUSH_VALUE, minMaxStack.pop());
    }

    @Test
    void testCannotPeekOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }
}