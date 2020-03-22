package cache;

import java.util.Date;

public class CacheEntry {

    String key;
    String value;
    Integer ttl;
    Date insertionTime;
    Date timeToRemove;

    public CacheEntry(String key, String value, Integer ttl, Date insertionTime) {
        this.key = key;
        this.value = value;
        this.ttl = ttl;
        this.insertionTime = insertionTime;
        this.timeToRemove = new Date(insertionTime.getTime() + ttl);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Date getInsertionTime() {
        return insertionTime;
    }

    public void setInsertionTime(Date insertionTime) {
        this.insertionTime = insertionTime;
    }

    public Date getTimeToRemove() {
        return timeToRemove;
    }

    public void setTimeToRemove(Date timeToRemove) {
        this.timeToRemove = timeToRemove;
    }

    @Override
    public String toString() {
        return "CacheEntry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", ttl=" + ttl +
                ", insertionTime=" + insertionTime +
                ", timeToRemove=" + timeToRemove +
                '}';
    }
}
