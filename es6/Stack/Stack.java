package es6.Stack;

import java.util.ArrayList;

public class Stack implements Stack_interface {
    private ArrayList<Integer> elements;
    int maxSize;
    int currentSize;

    public Stack(int maxSize) {
        elements = new ArrayList<>();
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    @Override
    public void push(int n) {
        synchronized (elements) {
            while (currentSize >= maxSize) {
                try {
                    elements.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted while waiting to push to stack");
                }
            }
            elements.add(n);
            currentSize++;
            elements.notifyAll(); // Notify any waiting threads that an item has been added
        }
    }
    @Override
    public int pop() {
        synchronized (elements) {
            while (isEmpty()) {
                try {
                    elements.wait();
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted while waiting to pop from stack");
                }
            }
            int value = elements.get(--currentSize);
            elements.remove(currentSize);
            return value;
        }
    }
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
