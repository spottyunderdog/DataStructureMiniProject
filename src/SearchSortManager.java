import DataStructures.DynamicArray;

public class SearchSortManager {
    /**
     *
     * Search through an unstorted or sorted list of resources
     * for the specified resource. Checks the provided ID against
     * the ids of the resources in provided catalog
     *
     * returns null if there is no resource with a matching id.
     *
     * @param catalog    The list of current Student Resources.
     * @param resourceId The id of the resource being searched for
     * @return Resource with matching id
     */
    public Resource linearSearch(DynamicArray<Resource> catalog, int resourceId) {
        return null;
    }

    /**
     * Search an already sorted list for the resource with a matching ID.
     * If the list is unsorted, sort it, then search.
     *
     * @param catalog DynamicArray of Resources to be searched
     * @param resourceId ID of Resource to be searched for
     * @return
     */
    public Resource binarySearch(DynamicArray<Resource> catalog, int resourceId) {
        return null;
    }


    /**
     * Sort the specified DynamicArray by inssertion sort
     * @param catalog
     */
    public void insertionSort(DynamicArray<Resource> catalog){

    }

    /**
     * Sort the specified DynamicArray by merge Sort
     * @param catalog
     */
    public void mergeSort(DynamicArray<Resource> catalog) {

    }

}
