package moduleD;

import moduleA.Resource;
import java.util.Iterator;
import java.util.List;

public class ResourceListProcessor {

    // List traversal With Iterator
    public static void display(List<Resource> list) {
        if ( list.isEmpty() ) {
            System.out.println(" (empty)");
        }
        Iterator<Resource> it = list.iterator();
        int n = 1;
        while ( it.hasNext() ) System.out.printf(" %d. %s%n", n++, it.next());
    }

    // Removing item from list while traversing with iterator
    public static int removeUnavailable(List<Resource> list) {
        int removed = 0;
        Iterator<Resource> it = list.iterator();
        while ( it.hasNext() ) {
            if ( !it.next().getAvailability() ) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }
}
