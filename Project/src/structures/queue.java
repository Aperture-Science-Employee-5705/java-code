package structures;

import java.*;

//WARNING : untested code
public class queue<T> {
    private int front ,rear ,maxSize ,size;
    private T[] queue;

    public queue(int Size) {
        front = 0;
        rear = -1;
        maxSize = Size;
        size = 0;
        queue = (T[]) new Object[maxSize];
    }

    public boolean isFull() {
        return size == maxSize;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean enQueue(T item) {
        if (isFull()) {
            System.out.println("ERROR : queue is full");
            return false;
        }
        if (rear == maxSize-1) {
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = item;
        size++;
        return true;
    }
    public T deQueue() {
        T item = (isEmpty() ? null : queue[front]);
        if (front == maxSize-1) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return item;
    }
}

