package moduleA;

import java.util.Arrays;

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 4;
    private int size;
    private T[] array;

    public DynamicArray() { this(DEFAULT_CAPACITY); }
    @SuppressWarnings("unchecked")
    public DynamicArray(int size){
        if (size <= 0) throw new IllegalArgumentException("Capcity must be greater than 0");
        this.size = 0;
        array = (T[]) new Object[size];
    }

    /**
     * Add an item to the array.
     * when array is full, allocates a larger array and copys the exiting elements
     * then sets then new array to current.
     * @param item the object added to the array.
     */
    public void add(T item) {
        if ( size == array.length) { resize(size * 2); }
        array[size] = item;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    public void remove(int index) {
        for ( int i = index; i < size; i++ ) {
            if ( i == size - 1 ) {
                array[i] = null;
                break;
            }
            else {
                array[i] = array[i+1];
            }
        }
        size--;
        if ( size < array.length / 2 && size >= 5 ) resize((array.length / 2) + 2 );
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(T item) {
        for ( T data : array ) {
            if ( data.equals(item) ) {
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        return array;
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity); // allocates a new array and copies elements
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index + " (size is " + size + ")");
        }
    }

}
