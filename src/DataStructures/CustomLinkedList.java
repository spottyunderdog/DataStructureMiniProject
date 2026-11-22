package DataStructures;

public class CustomLinkedList<T> {
    private class Node {
        T data;
        Node prev;
        Node next;
        Node(T data) {
            this.data = data;
            prev = next = null;
        }
    }
}
