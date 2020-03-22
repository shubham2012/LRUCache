package cache;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CacheImpl implements Cache{

    private static int defaultTtl = 600000; // 10 Min default TTL
    private Map<String, CacheEntry> map;
    private int size;
    private PriorityQueue<CacheEntry> queue = new PriorityQueue<>(
            Comparator.comparing(CacheEntry::getTimeToRemove));
    public CacheImpl(int size) {
        this.size = size;
        map = new LinkedHashMap<>();
    }

    public String get(String key) {
        if (map.containsKey(key)) {
            CacheEntry val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val.getValue();
        } else {
            return null;
        }
    }

    public void add(String key, String value, Integer ttl) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= size) {
            int toRemove = map.size() - size + 1;
            for (Map.Entry<String, CacheEntry> records : map.entrySet()) {
                map.remove(records.getKey());
                queue.remove(records.getValue());
                toRemove--;
                if (toRemove < 1)
                    break;
            }
        }
        removeQueueEntry();
        if (ttl == null) {
            ttl = defaultTtl;
        }
        CacheEntry cacheEntry = new CacheEntry(key, value, ttl, new Date());
        map.put(key, cacheEntry);
        queue.add(cacheEntry);
    }

    private void removeQueueEntry() {
        Date currDate = new Date();
        while (true){
            CacheEntry peek = queue.peek();
            if (peek !=null && peek.getTimeToRemove().before(currDate)){
                CacheEntry poll = queue.poll();
                map.remove(poll.getKey());
                continue;
            } else {
                break;
            }
        }
    }

    public void evict(String key) {
        map.remove(key);
    }

    public void print() {
        System.out.println(map);
    }

}
