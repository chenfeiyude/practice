import java.util.LinkedList;
import java.util.List;

/**
 * Least Recent Use Cache
 */
public class LRU {
    private LinkedList<Integer> cacheList;
    private int capability;
    public LRU(int capability) {
        cacheList = new LinkedList<>();
        this.capability = capability;
    }

    public void refer(int page) {
        if (cacheList.contains(page))
            cacheList.remove((Integer) page);
        else {
            if (cacheList.size() == capability)
                cacheList.removeLast();
        }
        cacheList.addFirst(page);
    }

    public void print() {
        if (!cacheList.isEmpty()) {
            for (Integer cache : cacheList) {
                System.out.println(cache);
            }
        }
    }

    public static void main(String[] args) {
        LRU lruCache = new LRU(4);
        // 1 -> 21 -> 321 -> 4321 -> 1432 -> 5143 -> 4513 -> 7451 -> 1745
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(4);
        lruCache.refer(1);
        lruCache.refer(5);
        lruCache.refer(4);
        lruCache.refer(7);
        lruCache.refer(1);

        lruCache.print();
    }
}
