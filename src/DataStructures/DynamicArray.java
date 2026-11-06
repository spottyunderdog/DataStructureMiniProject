package DataStructures;

public class DynamicArray<T> {
    private int size;
    private T[] array;

    public DynamicArray(int size){
        this.size = size;
        array = (T[]) new Object[size];
    }

    /**
     * Add an item to the array.
     * wehn array is full, allocats a larger array and copys the exiting elements
     * then sets then new array to current.
     * @param item the object added to the array.
     */
    public void add(T item) {
        // TODO: Implement method.
        array[0] = item;
    }

    public T get(int index) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, T item) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
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
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        for ( T item : array ) {
            if ( item.equals(null) ){
                return true;
            }
        }
        return false;
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

}
