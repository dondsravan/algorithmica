package com.algorithmica.assignment.four.lfucache;

public class LFUCacheTest {

	public static void main(String[] args) {
		LFUCache<Integer, Integer> cache = new LFUCacheImpl(5);
		cache.put(1, 10);
		cache.display();
		cache.put(1, 11);
		cache.put(2, 20);
		cache.display();
		cache.put(3, 30);
		cache.put(4, 40);
		cache.put(5, 50);
		cache.display();
		cache.get(1);
		cache.get(2);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);
		cache.get(4);
		cache.get(4);
		cache.put(6, 60);
		cache.display();
		cache.put(10, 60);
		cache.display();
		cache.clear();
		cache.display();
	}

}
