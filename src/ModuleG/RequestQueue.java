package ModuleG;

import moduleA.Identifiable;
import moduleB.CustomLinkedList;

/**
 * First in first Out queue built on our CustomLinkedList class.
 * enqueue adds to read and dequeue removes from the "front".
 *
 * @param <T> Any object that implements our Identifiable interface
 */
public class RequestQueue<T extends Identifiable> {
    private final CustomLinkedList<T> list = new CustomLinkedList<>();

    public boolean enqueue(T request) { return list.insertBack(request); }

    public T dequeue() { return list.removeFront(); }

    public T peek() {
        for ( T first : list ) return first; // first item in iteration is the first item in queue
        return null;
    }

    public boolean isEmpty() { return list.isEmpty(); }

    public int size() { return list.size(); }

    public void display() {
        if ( isEmpty() ) {
            System.out.println(" (no pending requests)");
            return;
        }
        list.display();
    }

}
