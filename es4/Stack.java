package es4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack <E> implements Iterable<E> {
    ArrayList<E> elements;
    int maxSize;
    int currentSize;

    public Stack(int maxSize) {
        elements = new ArrayList<>();
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    private boolean isFull() {
        return currentSize >= maxSize;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public void push(E e) throws FullException {
        if (isFull()) {
            throw new FullException("Stack is full");
        }
        elements.add(e);
        currentSize++;
    }

    public E pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return elements.remove(--currentSize);
    }

    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(--currentSize);
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        int position;
        StackIterator() {
            position = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return position >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {;
                throw new EmptyStackException();
            }
            return elements.get(position--);
        }
    }

    public void pushAll(Stack <? extends E> s) throws FullException {
        for (E e : s) {
            this.push(e);
        }
    }

    public void pushAllIn(Stack <? super E> s) throws FullException {
        s.pushAll(this);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (E e : elements) {
            str.append(e).append(" ");
        }
        return str.toString();
    }
}
