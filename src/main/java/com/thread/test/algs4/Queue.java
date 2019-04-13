package com.thread.test.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    private int n;

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public void enqueue(T t) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = t;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public T dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        T t = first.item;
        first = first.next;
        n --;
        if(isEmpty()) last = null;
        return t;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * return the item least recently add to this queue;
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Nothing to return.");
        }
        return first.item;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

    private  class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw  new NoSuchElementException();
            }
            T t = current.item;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            action.accept(next());
        }
    }



    private static class Node<T> {
        private T item;
        private Node<T> next;
    }


    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        q.enqueue("h");
        q.enqueue("e");
        q.enqueue("l");
        q.enqueue("l");
        q.enqueue("o");
        int len = q.size();
        for (int i = 0 ;i <len  ;i ++){
            System.out.println(q.dequeue());
        }
    }
}
