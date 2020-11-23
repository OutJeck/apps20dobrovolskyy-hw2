package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    Object peek() {
        return queue.getFirst();
    }

    Object dequeue() {
        Object obj = this.peek();
        queue = queue.removeFirst();
        return obj;
    }

    void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
