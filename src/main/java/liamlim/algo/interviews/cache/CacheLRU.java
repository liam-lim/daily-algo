package liamlim.algo.interviews.cache;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://www.interviewcake.com/concept/java/lru-cache
 */

public class CacheLRU {

  @Test
  public void test_cache_LRU() {
    ICache<String, Integer> cacheLRU = new LRUCache();

    cacheLRU.setMaxCacheSize(3);
    Assert.assertEquals(3, cacheLRU.getMaxCacheSize());

    cacheLRU.set("1", 1);
    cacheLRU.set("2", 2);
    cacheLRU.set("3", 3);
    Assert.assertEquals(3, cacheLRU.getCacheSize());
    Assert.assertSame(3, cacheLRU.getMRUItem());
    Assert.assertSame(1, cacheLRU.getLRUItem());

    cacheLRU.set("4", 4);
    Assert.assertEquals(3, cacheLRU.getCacheSize());
    Assert.assertSame(4, cacheLRU.getMRUItem());
    Assert.assertSame(2, cacheLRU.getLRUItem());
  }

  interface ICache<K, V> {

    void set(K key, V value);

    // return -1 if not found
    V get(K key);

    int getMaxCacheSize();

    void setMaxCacheSize(int cacheCapacity);

    int getCacheSize();

    // most recently used item
    V getMRUItem();

    // least recently used item
    V getLRUItem();
  }

  public static class LRUCache implements ICache<String, Integer> {
    private final LinkedList<String> linkedList = new LinkedList<>();
    private final Map<String, Integer> map = new HashMap<>();
    private int maxCacheSize = 0;

    @Override
    public void set(String key, Integer value) {
      if (map.containsKey(key)) {
        linkedList.remove(key);
        linkedList.addFirst(key);
      }
      else if (linkedList.size() >= maxCacheSize) {
        linkedList.removeLast();
        linkedList.addFirst(key);
      }
      else {
        linkedList.addFirst(key);
      }

      map.put(key, value);
    }

    @Override
    public Integer get(String key) {
      if (map.containsKey(key)) {
        Integer value = map.get(key);
        linkedList.remove(key);
        linkedList.addFirst(key);
        return value;
      }

      return -1;
    }

    @Override
    public int getMaxCacheSize() {
      return maxCacheSize;
    }

    @Override
    public void setMaxCacheSize(int cacheCapacity) {
      this.maxCacheSize = cacheCapacity;
    }

    @Override
    public int getCacheSize() {
      return linkedList.size();
    }

    @Override
    public Integer getMRUItem() {
      String first = linkedList.getFirst();
      return map.get(first);
    }

    @Override
    public Integer getLRUItem() {
      String last = linkedList.getLast();
      return map.get(last);
    }

  }
}
