package cache;

import java.util.LinkedList;

/**
 * Most Recent Use Cache
 */
public class MRU {
    private LinkedList<Integer> cacheList;
    private int capability;
    public MRU(int capability) {
        cacheList = new LinkedList<>();
        this.capability = capability;
    }

    public void refer(int page) {
        if (cacheList.contains(page))
            cacheList.remove((Integer) page);
        else {
            if (cacheList.size() == capability)
                cacheList.removeFirst();
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
        MRU cache = new MRU(4);
        // 1 -> 21 -> 321 -> 4321 -> 1432 -> 5432 -> 4532 -> 7532 -> 1532
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.refer(1);
        cache.refer(5);
        cache.refer(4);
        cache.refer(7);
        cache.refer(1);

        cache.print();
    }
}
