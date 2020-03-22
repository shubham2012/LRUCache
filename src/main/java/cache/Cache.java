package cache;

public interface Cache {

    String get(String key);

    void add(String key, String value, Integer ttl);

    void evict(String key);

    void print();
}
