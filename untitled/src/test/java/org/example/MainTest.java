package org.example;

import org.example.Cache.CacheBucket;
import org.example.Cache.TimeProvider;
import org.example.Cache.time;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void mainTest() {
        TimeProvider mytime= new time();
        assertTrue(5==1+4);
        CacheBucket<Integer,Integer> mybucket = new CacheBucket<>(4, mytime);

        assertTrue(mybucket.size() == 0);
        //assertTrue(mybucket.get(0)==null);
        mybucket.put(5,11,2);
        assertTrue(mybucket.size() == 1);
        assertTrue(mybucket.get(5)==11);
        assertTrue(mybucket.containsKey(5));
        mytime.setCurrentTime(10);
        assertTrue(!mybucket.containsKey(5));
        assertNull(mybucket.get(11));
    }

}