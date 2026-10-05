package org.example.Cache;

@FunctionalInterface
public interface HashFunction<T> {
    int getBucketIndex(T key, int numBuckets); // Returns target bucket index[cite: 6]
}