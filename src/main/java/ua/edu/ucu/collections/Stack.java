package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    Object peek() {
        return stack.getLast();
    }

    Object pop() {
        Object obj = this.peek();
        stack = stack.removeLast();
        return obj;
    }

    void push(Object e) {
        stack = stack.addLast(e);
    }
}