package moduleF;

import java.util.Arrays;

public class ResourceStack<T> {

    private T[] items;
    private int size;

    public ResourceStack() { this(4); }

    @SuppressWarnings("unchecked")
    public ResourceStack(int initialCapacity) {
        if ( initialCapacity <= 0 ) throw new IllegalArgumentException("Capacity must be greater than 0");
        items = (T[]) new Object[initialCapacity];
    }

    public void push(T item) {
        if ( size == items.length ) items = Arrays.copyOf(items, items.length * 2 );
        items[size++] = item;
    }

    public T pop() {
        if ( isEmpty() ) throw new IllegalStateException("Stack is empty: Nothing to pop");
        T top = items[--size];
        items[size] = null;
        return top;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty: nothing to peek at");
        return items[size - 1];
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void display() {
        if ( isEmpty() ) {
            System.out.println(" (empty)");
            return;
        }
        for ( int i = size - 1; i >= 0; i++ ) {
            System.out.println("  " + (i == size - 1 ? "-> " : "   ") + items[i]
                    + (i == size - 1 ? "   (top / current)" : ""));
        }
    }

}
