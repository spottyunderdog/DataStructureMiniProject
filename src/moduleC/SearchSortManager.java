package moduleC;

import moduleA.DynamicArray;
import moduleA.Resource;

import java.util.Comparator;

public class SearchSortManager {

    public static final Comparator<Resource> BY_ID = Comparator.comparingInt(Resource::getId);
    public static final Comparator<Resource> BY_NAME = ( Resource a, Resource b) ->
            a.getName().compareToIgnoreCase(b.getName());
    public static final Comparator<Resource> BY_POPULARITY = ( Resource a, Resource b ) ->
            Integer.compare(b.getPopularityScore(), a.getPopularityScore());
    public static final Comparator<Resource> By_AVAILABILITY = ( Resource a, Resource b ) -> {
        int c = Boolean.compare(b.getAvailability(), a.getAvailability());
        return c != 0 ? c : BY_NAME.compare(a,b);
    };

    private int lastComparisons;
    private boolean lastSearchNeededSort;

    public int getLastComparisons() { return lastComparisons; };

    public boolean lastSearchNeededSort() { return lastSearchNeededSort; }

    // ===================== Searching ======================
    public Resource linearSearch(DynamicArray<Resource> catalog, int resourceId) {
        lastComparisons = 0;
        for (int i = 0; i < catalog.size(); i++ ) {
            lastComparisons++;
            if ( catalog.get(i).getId() == resourceId ) return catalog.get(i);
        }
        return null;
    }

    public Resource linearSearchByName(DynamicArray<Resource> catalog, String name) {
        lastComparisons = 0;
        for ( int i = 0; i < catalog.size(); i++ ) {
            lastComparisons++;
            if ( catalog.get(i).getName().equalsIgnoreCase(name) ) return catalog.get(i);
        }
        return null;
    }

    public Resource binarySearch(DynamicArray<Resource> catalog, int resourceId) {
        DynamicArray<Resource> sorted = sortedByKey(catalog, BY_ID);
        return binarySearchCore(sorted, r -> Integer.compare(r.getId(), resourceId));
    }

    public Resource binarySearchByName(DynamicArray<Resource> catalog, String name) {
        DynamicArray<Resource> sorted = sortedByKey(catalog, BY_NAME);
        return binarySearchCore(sorted, r -> r.getName().compareToIgnoreCase(name));
    }

    private interface KeyComparison { int compareToKey(Resource element); }

    private Resource binarySearchCore(DynamicArray<Resource> sorted, KeyComparison cmp) {
        lastComparisons = 0;
        int low = 0, high = sorted.size() - 1;
        while ( low <= high ) {
            int mid = low + ( high - low ) / 2;
            lastComparisons++;
            int c = cmp.compareToKey(sorted.get(mid));
            if ( c == 0 ) return sorted.get(mid);
            if ( c < 0 ) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    private DynamicArray<Resource> sortedByKey(DynamicArray<Resource> catalog, Comparator<Resource> key) {
        lastSearchNeededSort = !isSortedBy(catalog, key);
        if ( !lastSearchNeededSort ) return catalog;
        DynamicArray<Resource> copy = copyOf(catalog);
        mergeSort(copy, key);
        return copy;
    }

    public boolean isSortedBy(DynamicArray<Resource> catalog, Comparator<Resource> key) {
        for ( int i = 1; i < catalog.size(); i++ ) {
            if ( key.compare(catalog.get(i - 1), catalog.get(i)) > 0 ) return false;
        }
        return true;
    }

    public DynamicArray<Resource> copyOf(DynamicArray<Resource> catalog) {
        DynamicArray<Resource> copy = new DynamicArray<>(Math.max(1, catalog.size()));
        for ( int i = 0; i < catalog.size(); i++ ) copy.add(catalog.get(i));
        return copy;
    }

    public void insertionSort(DynamicArray<Resource> catalog, Comparator<Resource> key) {
        for ( int i = 1; i < catalog.size(); i++ ) {
            Resource current = catalog.get(i);
            int j = i - 1;
            while ( j >= 0 && key.compare(catalog.get(j), current) > 0 ) {
                catalog.set( j+ 1, catalog.get(j));
                j--;
            }
            catalog.set(j + 1,current);
        }
    }

    public void mergeSort(DynamicArray<Resource> catalog, Comparator<Resource> key) {
        int n = catalog.size();
        if ( n < 2 ) return;
        Resource[] items = new Resource[n];
        for ( int i = 0; i < n; i++ ) items[i] = catalog.get(i);
        mergeSort(items, new Resource[n], 0, n - 1, key);
        for ( int i = 0; i < n; i++ ) catalog.set(i, items[i]);
    }

    private void mergeSort(Resource[] a, Resource[] tmp, int lo, int hi, Comparator<Resource> key) {
        if ( lo >= hi ) return;
        int mid = lo + ( hi - lo ) / 2;
        mergeSort(a, tmp, lo, mid, key);
        mergeSort(a, tmp, mid + 1, hi, key);
        int i = lo, j = mid + 1, k = lo;
        while ( i <= mid && j <= hi ) {
            tmp[k++] = key.compare(a[i], a[j]) <= 0 ? a[i++] : a[j++];
        }
        while ( i <= mid ) tmp[k++] = a[i++];
        while ( j <= hi ) tmp[k++] = a[j++];
        for ( k = lo; k <= hi; k++ ) a[k] = tmp[k];
    }
}
