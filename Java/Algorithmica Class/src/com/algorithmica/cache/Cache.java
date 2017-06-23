package com.algorithmica.cache;

public interface Cache {
	
	Integer get(String key);

	void put(String key, Integer value);

	void display();
}
