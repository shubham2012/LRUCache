package cache;

import org.junit.jupiter.api.Test;

class CacheTest {

    private Cache cache = new CacheImpl(10);

    @Test
    void test_add() {
        cache.add("A","B", 1);
        cache.add("B","C", 500000);
        cache.add("C","A", 200000);
        cache.add("D","G", 100000);
        cache.add("Z","O", 100000);
        cache.add("M","K", 5000);
        cache.add("D","G", 6000);
        cache.print();
    }

}