package org.example.Cache;

public class CacheBucket<K,V>{
    int size=0;
    cache.CacheEntry<K,V>[] Tab ;
    TimeProvider timeComparator;

    public CacheBucket(int capacity,TimeProvider timeComparator) {
        this.Tab = new cache.CacheEntry[capacity];
        size = 0;
        timeComparator = timeComparator;

    }
    public void put(K key, V value,  long lifetime) {
        if (size == Tab.length) {
            if (size==0){
                cache.CacheEntry<K,V>[] newTab = new cache.CacheEntry<K,V>[2];

                Tab = newTab;
            }
            else{
                cache.CacheEntry<K,V>[] newTab = new cache.CacheEntry<K,V>[size*2];
                for(int j=0;j<size;j++){
                    newTab[j]=Tab[j];
                }
                Tab = newTab;
            }

        }
        long currentTime =timeComparator.currentTime();
        Tab[size]=new cache.CacheEntry(key,value, currentTime,lifetime);
        size++;
    }
    public V get(K key){
        long currentTime =timeComparator.currentTime();

        for(int j=0;j<size;j++){
            if (Tab[j].getKey().equals(key)){
                if (Tab[j].isExpired(currentTime)){
                    return null;
                }
                else{
                    return (V) Tab[j].getValue();
                }
            }
        }
        return null;
    }
    public boolean containsKey(K key){
        long currentTime =timeComparator.currentTime();
        for(int j=0;j<size;j++){
            if (Tab[j].getKey().equals(key)){
                return !Tab[j].isExpired(currentTime);
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
}
