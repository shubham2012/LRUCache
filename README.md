# LRUCache
LRUCache Impl with TTL

LRU Cache implementation along with TTL.

Implement an in-memory caching library to store (key, value) objects for faster retrieval. Key requirements of the library are as follows:
1. The Cache will have fixed capacity specified at initialization time to limit memory usage
2. Storage and retrieval from Cache should be fast
3. Cache should support efficient replacement based on configurable eviction policy (eg. LRU -
Least Recently Used) when trying to insert in a full cache
4. Support expiry of cache entries based on TTL (time to live in seconds) value specified at time of
cache insert.
