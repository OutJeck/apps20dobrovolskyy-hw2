package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    Stack stack;

    @Before
    public void setUP() {
        this.stack = new Stack();

        stack.push(1);
        stack.push('2');
        stack.push(3.0);
        stack.push("four");
    }

    @Test
    public void testPeak() {
        assertEquals(stack.peek(), "four");
    }

    @Test
    public void testPop() {
        assertEquals(stack.pop(), "four");
        assertEquals(stack.pop(), 3.0);
        assertEquals(stack.pop(), '2');
        assertEquals(stack.pop(), 1);
    }

}