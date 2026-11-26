package moduleB;

import moduleA.Identifiable;
import moduleA.Resource;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T extends Identifiable> implements Iterable<T> {
    private class Node {
        T data;
        Node prev;
        Node next;
        Node(Resource data) { this.data = data; }
    }

    Node head;
    Node tail;
    int size;
    public boolean insertFront( Resource data) {
        if ( contains( data.getId()) ) return false;
        Node newNode = new Node(data);
        if ( head == null ) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertBack( Resource data) {
        if ( contains( data.getId() ) == null ) return false;
        Node newNode = new Node(data);
        if ( tail == null ) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public T removeFront() {
        if ( head == null ) return null;
        Node temp = head;
        head = head.next;
        if ( head == null ) tail = null;
        else head.prev = null;
        size--;
        return  temp.data;
    }

    public T removeBack() {
        if ( tail == null ) return null;
        Node temp = tail;
        tail = tail.prev;
        if ( tail == null ) head = null;
        else tail.next = null;
        size--;
        return  temp.data;
    }

    public T removeId(int id) {
        Node current = head;
        while ( current != null && current.data.getId() != id ) current = current.next;
        if ( current == null ) return null;
        if ( current.prev == null ) head = current.next;
        else current.prev.next = current.next;
        if ( current.next == null ) tail = current.prev;
        else current.next.prev= current.prev;
        size--;
        return current.data;
    }

    public T searchById(int id) {
        for ( Node current = head; current != null; current = current.next ) {
            if ( current.data.getId() == id) return current.data;
        }
        return null;
    }

    public boolean contains(int id) { return searchById(id) != null; }

    public boolean isEmpty() { return size == 0; }

    public void display() {
        if ( isEmpty() ) {
            System.out.println(" (Empty");
            return;
        }
        int n = 1;
        for (T item : this ) System.out.printf( "%d. %s%n:", n++, item);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node next = head;
            @Override
            public boolean hasNext() { return next != null; }

            @Override
            public T next() {
                if ( next == null ) throw new NoSuchElementException();
                T value = next.data;
                next = next.next;
                return value;
            }
        }
    }

}
