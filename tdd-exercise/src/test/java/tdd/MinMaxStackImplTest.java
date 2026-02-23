package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack minMaxStack;

    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testCannotPopOnEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }
}