package cache;

public class CacheEntry<K, V> {
    private final K key;
    private final V value;
    private final long creationTime;
    private final long lifetime;


    public CacheEntry(K key, V value, long creationTime, long lifetime) {
        this.key = key;
        this.value = value;
        this.creationTime = creationTime;
        this.lifetime = lifetime;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLifetime() {
        return lifetime;
    }

    public boolean isExpired(long currentTime) {
        return (currentTime - creationTime) >= lifetime;
    }



}