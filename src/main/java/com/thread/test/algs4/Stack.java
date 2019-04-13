package com.thread.test.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private int n;

    private Node<T> first;


    public Stack() {
        this.n = 0;
        this.first = null;
    }

    public void push(T t) {
        Node oldFrist = first;
        first = new Node<>();
        first.item = t;
        first.next = oldFrist;
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is emtpy");
        }
        T t = first.item;
        first = first.next;
        n--;
        return t;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node<T> {
        private Node next;
        private T item;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pop());
        }

    }
}
