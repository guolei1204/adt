package com.thread.test.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Bag<T> implements Iterable<T> {

    private Node<T> first;

    private int n;

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(T t) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = t;
        first.next = oldFirst;
        n++;
    }

    private static class Node<T> {
        private T item;
        private Node next;
    }

    @Override
    public Iterator iterator() {
        return new ListInterator<T>(first);
    }

    @Override
    public void forEach(Consumer action) {
        for (T t : this) {
            action.accept(t);
        }
    }


    private class ListInterator<T> implements Iterator {
        private Node<T> current;

        public ListInterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException("");
            T t = current.item;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("h");
        bag.add("e");
        bag.add("l");
        bag.add("l");
        bag.add("o");

        bag.forEach(System.out::println);
    }
}
