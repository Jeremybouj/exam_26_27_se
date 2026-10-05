package org.example.Cache;

public interface TimeProvider {
    long currentTime(); // Returns current time in milliseconds[cite: 6]
    public void setCurrentTime(long currentTime);
}
