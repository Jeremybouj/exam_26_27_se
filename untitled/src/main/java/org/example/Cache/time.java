package org.example.Cache;

public class time implements TimeProvider {
    public long currentTime = 0;

    @Override
    public long currentTime() {
        return currentTime;
    }
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
}
