package moduleB;

import moduleA.Resource;

public class FavoriteResourceList {
    private class Node {
        Resource data;
        Node prev;
        Node next;
        Node(Resource data) {
            this.data = data;
            prev = next = null;
        }
    }

    Node head;
    Node tail;
    int size;
    public FavoriteResourceList() {
        head = tail = null;
        size = 0;
    }

    public void insertFront( Resource data) {
        if ( searchById( data.getId() ) == null ) return;
        Node newNode = new Node(data);
        if ( head == null ) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertBack( Resource data) {
        if ( searchById( data.getId() ) == null ) return;
        Node newNode = new Node(data);
        if ( tail == null ) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Resource removeFront() {
        if ( head == null ) return null;
        Node temp = head;
        head = head.next;
        if ( head == null ) tail = null;
        else head.prev = null;
        size--;
        return  temp.data;
    }

    public Resource removeBack() {
        if ( tail == null ) return null;
        Node temp = tail;
        tail = tail.prev;
        if ( tail == null ) head = null;
        else tail.next = null;
        size--;
        return  temp.data;
    }

    public Resource removeId(int resourceId) {
        Node current = head;
        while ( current != null ) {
            Resource resource = current.data;
            if ( resource.getId() == resourceId ) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return resource;
            }
            current = current.next;
        }
        return null;
    }

    public Resource searchById(int resourceId) {
        Node current = head;
        while ( current != null ) {
            Resource resource = current.data;
            if ( resource.getId() == resourceId ) {
                return resource;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        Node current = head;
        while ( current != null ) {
            System.out.printf("Resource: %s%n", current.data);
            current = current.next;
        }
    }

}
